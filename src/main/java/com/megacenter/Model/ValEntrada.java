package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "valentrada")
public class ValEntrada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idValentrada;

	@Column(name = "cantidad", nullable = false, length = 11)
	private int cantidad;

	@Column(name = "precio", nullable = false, precision = 11, scale = 2)
	private double precio;

	@Column(name = "origen", nullable = false, length = 70)
	private String origen;

	@ManyToOne
	@JoinColumn(name = "id_Producto", nullable = false)
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "id_Almacen", nullable = false)
	private Almacen almacen;

	public int getIdValentrada() {
		return idValentrada;
	}

	public void setIdValentrada(int idValentrada) {
		this.idValentrada = idValentrada;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

}
