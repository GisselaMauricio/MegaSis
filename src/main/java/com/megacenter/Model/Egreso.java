package com.megacenter.Model;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "egreso")
public class Egreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEgreso;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha;

    @Column(name = "tipoPago", nullable = false, length = 20)
    private String tipoPago;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "benificiario", nullable = false, length = 50)
    private String benificiario;

    @Column(name = "monto", nullable = false, precision = 11, scale = 2)
    private BigDecimal monto;

    //private Caja IdCaja;

    public int getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(int idEgreso) {
        this.idEgreso = idEgreso;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBenificiario() {
        return benificiario;
    }

    public void setBenificiario(String benificiario) {
        this.benificiario = benificiario;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

}
