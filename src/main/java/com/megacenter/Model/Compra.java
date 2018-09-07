package com.megacenter.Model;

import java.time.LocalDateTime;

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
@GeneratedValue(strategy = GenerationType.AUTO)
private int idCompra;

@ManyToOne
@JoinColumn(name="id_proveedor", nullable=false)
private Proveedor proveedor;

@JsonSerialize(using=ToStringSerializer.class)
private LocalDateTime fecha;

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

public LocalDateTime getFecha() {
	return fecha;
}

public void setFecha(LocalDateTime fecha) {
	this.fecha = fecha;
}

}
