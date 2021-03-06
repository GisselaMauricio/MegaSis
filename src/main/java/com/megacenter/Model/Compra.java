package com.megacenter.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "compra")
/*@JsonIdentityInfo(
        generator= ObjectIdGenerators.PropertyGenerator.class,
        property="idCompra")*/
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompra;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;

    @OneToOne
    @JoinColumn(name = "id_tipocomprobante", nullable = false)
    private TipoComprobante tipocomprobante;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fecha;

    @Column(name = "montoTotal", nullable = false, precision = 11, scale = 2)
    private Double montoTotal;

    @Column(name = "guiaRemision", nullable = false, length = 20)
    private String guiaRemision;

    @Column(name = "numeroComprobante", nullable = false, length = 20)
    private String numeroComprobante;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCompra> detalleCompra = new ArrayList<>();

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getGuiaRemision() {
        return guiaRemision;
    }

    public void setGuiaRemision(String guiaRemision) {
        this.guiaRemision = guiaRemision;
    }

    public List<DetalleCompra> getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(List<DetalleCompra> detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public TipoComprobante getTipocomprobante() {
        return tipocomprobante;
    }

    public void setTipocomprobante(TipoComprobante tipocomprobante) {
        this.tipocomprobante = tipocomprobante;
    }
}
