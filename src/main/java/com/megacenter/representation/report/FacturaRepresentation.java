package com.megacenter.representation.report;

import java.math.BigDecimal;
import java.util.List;

public class FacturaRepresentation {
    private String denonimacionEntidad;
    private String rucEntidad;
    private String telefonoEntidad;
    private String sloganEntidad;
    private String direccionEntidad;

    private String tipoDocumento;
    private String numeroDocumento;

    private String denominacionCliente;
    private String direccionCliente;
    private String rucCliente;
    private String numeroGuia;
    private String fechaDocumento;

    private String totalLetras;

    private BigDecimal subTotal;
    private BigDecimal totalIGV;
    private BigDecimal total;

    private byte[] logo;

    private List<FacturaDetalleRepresentation> detalle;

    public String getDenonimacionEntidad() {
        return denonimacionEntidad;
    }

    public void setDenonimacionEntidad(String denonimacionEntidad) {
        this.denonimacionEntidad = denonimacionEntidad;
    }

    public String getRucEntidad() {
        return rucEntidad;
    }

    public void setRucEntidad(String rucEntidad) {
        this.rucEntidad = rucEntidad;
    }

    public String getTelefonoEntidad() {
        return telefonoEntidad;
    }

    public void setTelefonoEntidad(String telefonoEntidad) {
        this.telefonoEntidad = telefonoEntidad;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getSloganEntidad() {
        return sloganEntidad;
    }

    public void setSloganEntidad(String sloganEntidad) {
        this.sloganEntidad = sloganEntidad;
    }

    public String getDireccionEntidad() {
        return direccionEntidad;
    }

    public void setDireccionEntidad(String direccionEntidad) {
        this.direccionEntidad = direccionEntidad;
    }

    public String getDenominacionCliente() {
        return denominacionCliente;
    }

    public void setDenominacionCliente(String denominacionCliente) {
        this.denominacionCliente = denominacionCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(String fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getTotalLetras() {
        return totalLetras;
    }

    public void setTotalLetras(String totalLetras) {
        this.totalLetras = totalLetras;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTotalIGV() {
        return totalIGV;
    }

    public void setTotalIGV(BigDecimal totalIGV) {
        this.totalIGV = totalIGV;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<FacturaDetalleRepresentation> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<FacturaDetalleRepresentation> detalle) {
        this.detalle = detalle;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
}
