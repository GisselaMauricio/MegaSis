package com.megacenter.Model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleVenta")
public class DetalleVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleVenta;
	
	@Column(name = "cantidad", nullable = true, length = 11)
	private String cantidad;
	
	@Column(name = "precio", nullable = true, precision = 11, scale = 2)
	private Double precio;
	
	@Column(name = "importeTotalItem", nullable = true, precision = 11, scale = 2)
	private Double importeTotalItem;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta")
	@JsonIgnore
	private Venta venta;
			
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
	private Producto producto;

	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Double getImporteTotalItem() {
		return importeTotalItem;
	}

	public void setImporteTotalItem(Double importeTotalItem) {
		this.importeTotalItem = importeTotalItem;
	}
}
