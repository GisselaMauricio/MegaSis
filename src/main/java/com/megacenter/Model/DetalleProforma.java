package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_proforma")
public class DetalleProforma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;

	@Column(name = "cantidaditem", nullable = false, length = 11)
	private int cantidaditem;

	@Column(name = "precioitem", nullable = false, precision = 11, scale = 2)
	private double precioitem;

	@Column(name = "importetotalitem", nullable = false, precision = 11, scale = 2)
	private double importetotalitem;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto producto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_proforma", nullable = false)
	private Proforma proforma;

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getCantidaditem() {
		return cantidaditem;
	}

	public void setCantidaditem(int cantidaditem) {
		this.cantidaditem = cantidaditem;
	}

	public double getPrecioitem() {
		return precioitem;
	}

	public void setPrecioitem(double precioitem) {
		this.precioitem = precioitem;
	}

	public double getImportetotalitem() {
		return importetotalitem;
	}

	public void setImportetotalitem(double importetotalitem) {
		this.importetotalitem = importetotalitem;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Proforma getProforma() {
		return proforma;
	}

	public void setProforma(Proforma proforma) {
		this.proforma = proforma;
	}

}
