package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "almacen")
public class Almacen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlmacen;

	@Column(name = "nombreAlmacen", nullable = false, length = 50)
	private String nombreAlmacen;

	@Column(name = "stock", nullable = false, length = 11)
	private int stock;

	@OneToMany
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto producto;

	public int getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
