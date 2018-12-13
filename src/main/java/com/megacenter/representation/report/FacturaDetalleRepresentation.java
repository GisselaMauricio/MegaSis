package com.megacenter.representation.report;

import java.math.BigDecimal;

public class FacturaDetalleRepresentation {
    private String unidadMedida;
    private BigDecimal cantidad;
    private String decripcionServicio;
    private BigDecimal precioUnitario;
    private BigDecimal importe;

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getDecripcionServicio() {
        return decripcionServicio;
    }

    public void setDecripcionServicio(String decripcionServicio) {
        this.decripcionServicio = decripcionServicio;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
}
