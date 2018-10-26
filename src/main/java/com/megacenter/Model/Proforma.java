package com.megacenter.Model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "proforma")
public class Proforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProforma;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fecha;

    @Column(name = "numeroProforma", nullable = false, length = 10)
    private String numeroProforma;

    @Column(name = "acuenta", nullable = false, precision = 11, scale = 2)
    private double acuenta;

    @Column(name = "saldo", nullable = false, precision = 11, scale = 2)
    private double saldo;

    @Column(name = "total", nullable = false, precision = 11, scale = 2)
    private double total;

    //@ManyToOne
    //@JoinColumn(name = "id_personal", nullable = false)
    //private Personal personal;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "estadoProforma", nullable = true, length = 10)
    private String estadoProforma;

    @OneToMany(mappedBy = "proforma", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE}, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DetalleProforma> detalleProforma;

    public int getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(int idProforma) {
        this.idProforma = idProforma;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNumeroProforma() {
        return numeroProforma;
    }

    public void setNumeroProforma(String numeroProforma) {
        this.numeroProforma = numeroProforma;
    }

    public double getAcuenta() {
        return acuenta;
    }

    public void setAcuenta(double acuenta) {
        this.acuenta = acuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstadoProforma() {
        return estadoProforma;
    }

    public void setEstadoProforma(String estadoProforma) {
        this.estadoProforma = estadoProforma;
    }

    public List<DetalleProforma> getDetalleProforma() {
        return detalleProforma;
    }

    public void setDetalleProforma(List<DetalleProforma> detalleProforma) {
        this.detalleProforma = detalleProforma;
    }

}
