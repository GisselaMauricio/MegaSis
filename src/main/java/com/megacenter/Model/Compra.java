package com.megacenter.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name="compra")
public class Compra {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idCompra;

@ManyToOne
@JoinColumn(name="id_proveedor", nullable=false)
private Proveedor proveedor;

@ManyToOne
@JoinColumn(name="id_sucursal", nullable=false)
private Sucursal sucursal;

@JsonSerialize(using=ToStringSerializer.class)
private LocalDateTime fecha;

@Column(name = "MontoTotal", nullable = false, precision= 11,scale =2)
private Double montoTotal;

@Column(name = "guiaRemision", nullable = false, length = 10)
private String guiaRemision;


public int getIdCompra() {
	return idCompra;
}

public Sucursal getSucursal() {
	return sucursal;
}

public void setSucursal(Sucursal sucursal) {
	this.sucursal = sucursal;
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

public void setIdCompra(int idCompra) {
	this.idCompra = idCompra;
}

public Proveedor getProveedor() {
	return proveedor;
}

public void setProveedor(Proveedor proveedor) {
	this.proveedor = proveedor;
}

public LocalDateTime getFecha() {
	return fecha;
}

public void setFecha(LocalDateTime fecha) {
	this.fecha = fecha;
}

}
