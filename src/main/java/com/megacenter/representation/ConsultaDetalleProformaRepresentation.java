package com.megacenter.representation;

import java.math.BigDecimal;

public class ConsultaDetalleProformaRepresentation {
	// select b.cantidaditem,d.descripcion,c.nombre,b.precioitem, b.importetotalitem
	// from proforma a inner join detalle_proforma b on a.id_proforma=b.id_proforma
	// inner join producto c on b.id_producto=c.id_producto inner join unidadmedida
	// d on c.id_unidadmedida=d.id_unidadmedida
	private int cantidaditem;
	private String descripcion;
	private String nombre;
	private BigDecimal precioitem;
	private BigDecimal importetotalitem;

	public ConsultaDetalleProformaRepresentation() {
		// TODO Auto-generated constructor stub
	}

	public ConsultaDetalleProformaRepresentation(int cantidaditem, String descripcion, String nombre,
			BigDecimal precioitem, BigDecimal importetotalitem) {
		super();
		this.cantidaditem = cantidaditem;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precioitem = precioitem;
		this.importetotalitem = importetotalitem;
	}

	public int getCantidaditem() {
		return cantidaditem;
	}

	public void setCantidaditem(int cantidaditem) {
		this.cantidaditem = cantidaditem;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioitem() {
		return precioitem;
	}

	public void setPrecioitem(BigDecimal precioitem) {
		this.precioitem = precioitem;
	}

	public BigDecimal getImportetotalitem() {
		return importetotalitem;
	}

	public void setImportetotalitem(BigDecimal importetotalitem) {
		this.importetotalitem = importetotalitem;
	}

}
