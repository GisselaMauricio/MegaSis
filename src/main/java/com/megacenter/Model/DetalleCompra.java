package com.megacenter.Model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@Table(name = "detalleCompra")
/*@JsonIdentityInfo(
		generator=ObjectIdGenerators.PropertyGenerator.class,
		property="idDetalleCompra")*/
public class DetalleCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleCompra;

	@Column(name = "precioItem", nullable = true, precision = 11, scale = 2)
	private Double precioItem;

	@Column(name = "cantidaditem", nullable = true, length = 11)
	private String cantidaditem;

	@Column(name = "importeTotalItem", nullable = true, precision = 11, scale = 2)
	private Double importeTotalItem;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compra")
	@JsonIgnore
	private Compra compra;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
	private Producto producto;
	
	public int getIdDetalleCompra() {
		return idDetalleCompra;
	}

	public void setIdDetalleCompra(int idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}

	public Double getPrecioItem() {
		return precioItem;
	}

	public void setPrecioItem(Double precioItem) {
		this.precioItem = precioItem;
	}

	public String getCantidaditem() {
		return cantidaditem;
	}

	public void setCantidaditem(String cantidaditem) {
		this.cantidaditem = cantidaditem;
	}

	public Double getImporteTotalItem() {
		return importeTotalItem;
	}

	public void setImporteTotalItem(Double importeTotalItem) {
		this.importeTotalItem = importeTotalItem;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
