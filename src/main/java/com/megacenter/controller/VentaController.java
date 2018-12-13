package com.megacenter.controller;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import com.megacenter.Model.Producto;
import com.megacenter.Model.TipoComprobante;
import com.megacenter.dao.ITipoCambioDAO;
import com.megacenter.representation.report.FacturaRepresentation;
import com.megacenter.service.IProductoService;
import com.megacenter.util.ModelToRepresentation;
import com.megacenter.util.RepresentationToReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.megacenter.Model.DetalleVenta;
import com.megacenter.Model.Venta;
import com.megacenter.service.IVentaService;


@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService service;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ITipoCambioDAO tipoCambio;

    @Autowired
    private ModelToRepresentation modelToRepresentation;

    @Autowired
    private RepresentationToReport representationToReport;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Venta>> listar() {
        List<Venta> ventas = new ArrayList<>();
        try {
            ventas = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);
        }
        return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venta> listarId(@PathVariable("id") Integer id) {
        Venta venta = new Venta();
        venta = service.listarId(id);
        return new ResponseEntity<Venta>(venta, HttpStatus.OK);
    }

    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venta> registrar(@RequestBody Venta venta) {
        try {
            venta.setTipocambio(tipoCambio.getOne(1));
            Venta registro = service.getUltimoNumeroComprobante(venta.getTipocomprobante().getIdTipocomprobante());
            if (registro != null) {
                int numero = Integer.parseInt(registro.getNumeroComprobante());
                numero = numero + 1;
                Formatter fmt = new Formatter();
                fmt.format("%08d", numero);
                venta.setNumeroComprobante(String.valueOf(fmt));
                venta.setSerieComprobante(registro.getSerieComprobante());
            } else {
                venta.setNumeroComprobante("00000001");
                venta.setSerieComprobante("001");
            }

            Venta v = service.registrar(venta);
            v.getDetalleVenta().forEach(detallev -> {
                Producto producto = detallev.getProducto();
                producto.setStock(producto.getStock() - Integer.parseInt(detallev.getCantidad()));
                productoService.modificar(producto);
            });

            return new ResponseEntity<Venta>(v, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Venta>(new Venta(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> actualizar(@RequestBody Venta venta) {
        int resultado = 0;
        try {
            service.modificar(venta);
            resultado = 1;
        } catch (Exception e) {
            resultado = 0;
        }
        return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
        int resultado = 0;
        try {
            service.eliminar(id);
            resultado = 1;
        } catch (Exception e) {
            resultado = 0;
        }
        return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
    }

    @GetMapping(value = "/reporte-venta/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> reporteVenta(@PathVariable Integer id) {
        Venta model = service.listarId(id);
        FacturaRepresentation representation = modelToRepresentation.toRepresentation(model);
        byte[] reporte = representationToReport.toReport(representation);
        return new ResponseEntity<byte[]>(reporte, HttpStatus.OK);
    }


}
