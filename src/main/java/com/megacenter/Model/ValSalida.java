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
@Table(name = "valsalida")
public class ValSalida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idValsalida;

	@Column(name = "cantidad", nullable = false, length = 11)
	private int cantidad;

	@Column(name = "precio", nullable = false, precision = 11, scale = 2)
	private double precio;

	@Column(name = "origen", nullable = false, length = 50)
	private String origen;

	@Column(name = "destino", nullable = false, length = 100)
	private String destino;

	@ManyToOne
	@JoinColumn(name = "id_Producto", nullable = false)
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "id_Almacen", nullable = false)
	private Almacen almacen;

	public int getIdValsalida() {
		return idValsalida;
	}

	public void setIdValsalida(int idValsalida) {
		this.idValsalida = idValsalida;
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

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
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
