package com.megacenter.controller;

import java.util.ArrayList;
import java.util.List;

import com.megacenter.Model.Producto;
import com.megacenter.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.megacenter.Model.Compra;
import com.megacenter.service.ICompraService;


@RestController
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired
    private ICompraService service;
    @Autowired
    private IProductoService productoService;



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Compra>> listar() {
        List<Compra> compras = new ArrayList<>();
        compras = service.listar();
        return new ResponseEntity<List<Compra>>(compras, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Compra> listarId(@PathVariable("id") Integer id) {
        Compra Compra = new Compra();
        Compra = service.listarId(id);
        return new ResponseEntity<Compra>(Compra, HttpStatus.OK);
    }

    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Compra> registrar(@RequestBody Compra compra) {
        Compra c = new Compra();
        try {
            c = service.registrar(compra);
            //aqui aumentar stock productos
            c.getDetalleCompra().forEach(detalle -> {
                Producto producto = detalle.getProducto();
                producto.setStock(producto.getStock() + Integer.parseInt(detalle.getCantidaditem()));
                productoService.modificar(producto);
            });
            return new ResponseEntity<Compra>(c, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Compra>(c, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> actualizar(@RequestBody Compra compra) {
        int resultado = 0;
        try {
            service.modificar(compra);
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



}
