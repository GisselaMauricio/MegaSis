package com.megacenter.Model;



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
	private String precio;
	
	@Column(name = "importeTotal", nullable = true, precision = 11, scale = 2)
	private String importeTotal;
	
	@Column(name = "stockActual", nullable = true, length = 11)
	private String stockActual;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta")
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(String importeTotal) {
		this.importeTotal = importeTotal;
	}

	public String getStockActual() {
		return stockActual;
	}

	public void setStockActual(String stockActual) {
		this.stockActual = stockActual;
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
	
	
	
}
