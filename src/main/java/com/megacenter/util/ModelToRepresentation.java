package com.megacenter.util;

import com.megacenter.Model.DetalleVenta;
import com.megacenter.Model.Venta;
import com.megacenter.representation.report.FacturaDetalleRepresentation;
import com.megacenter.representation.report.FacturaRepresentation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ModelToRepresentation {

    public FacturaRepresentation toRepresentation(Venta model) {
        FacturaRepresentation rep = new FacturaRepresentation();

        /*____INI DATOS ESTATICOS___*/
        rep.setDenonimacionEntidad("MEGACENTER PERU");
        rep.setRucEntidad("10259878452");
        rep.setTelefonoEntidad("963258741 / 963852741");
        rep.setSloganEntidad("Compra y venta de Computadoras y accesorios/ Venta, Instalacion y Asesoria de Redes de Comunicacion");
        rep.setDireccionEntidad("JR. LIBERTAD N° 833 - AYACUCHO-HUAMANGA-AYACUCHO");
        /*___END DATOS ESTATICOS___*/

        rep.setTipoDocumento(model.getTipocomprobante().getDescripcion());
        rep.setNumeroDocumento(model.getSerieComprobante() + "-" + model.getNumeroComprobante());
        rep.setDenominacionCliente(model.getCliente().getPersona().getNombre());
        rep.setDireccionCliente(model.getCliente().getPersona().getDireccion());
        rep.setRucCliente(model.getCliente().getPersona().getNumeroDocumento());
        rep.setNumeroGuia("");
        rep.setFechaDocumento(model.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        rep.setTotalLetras(NumberToLetterConverter.convertNumberToLetter(NumberFormat.toBigDecimal(model.getMontoTotal(), 2)));
        rep.setSubTotal(NumberFormat.toBigDecimal(model.getSubTotal(), 2));
        rep.setTotalIGV(NumberFormat.toBigDecimal(model.getIgv(), 2));
        rep.setTotal(NumberFormat.toBigDecimal(model.getMontoTotal(), 2));

        List<FacturaDetalleRepresentation> detalle = new ArrayList<>();
        model.getDetalleVenta().forEach(d -> {
            detalle.add(toFacturaDetalle(d));
        });
        rep.setDetalle(detalle);
        return rep;
    }

    private FacturaDetalleRepresentation toFacturaDetalle(DetalleVenta model) {
        FacturaDetalleRepresentation rep = new FacturaDetalleRepresentation();
        rep.setUnidadMedida(model.getProducto().getUnidadMedida().getCodUnidadmedida());
        rep.setCantidad(NumberFormat.toBigDecimal(model.getCantidad(), 2));
        rep.setDecripcionServicio(model.getProducto().getNombre());
        rep.setPrecioUnitario(NumberFormat.toBigDecimal(model.getPrecio(), 2));
        if (model.getImporteTotal() != null) {
            rep.setImporte(NumberFormat.toBigDecimal(model.getImporteTotal(), 2));
        } else {
            rep.setImporte(NumberFormat.toBigDecimal(0, 2));
        }
        return rep;
    }

}
