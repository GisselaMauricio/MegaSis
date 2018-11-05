package com.megacenter.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta;
	
	@Column(name = "fecha", nullable = false, precision = 20)	
	private LocalDateTime fecha;
	
	@Column(name = "subTotal", nullable = false, precision = 11, scale = 2)
	private Double subTotal;
	
	@Column(name = "igv", nullable = false, precision = 11, scale = 2)
	private Double igv;
	
	@Column(name = "montoTotal", nullable = false, precision = 11, scale = 2)
	private Double montoTotal;
	
	@Column(name = "estadoVenta", nullable = false )
	private Double estadoVenta;

	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private TipoCambio tipoCambio;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
   private TipoPago tipoPago;
	
	@OneToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleVenta> detalleVenta= new ArrayList<>();
	
		public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Double getEstadoVenta() {
		return estadoVenta;
	}

	public void setEstadoVenta(Double estadoVenta) {
		this.estadoVenta = estadoVenta;
	}

	public TipoCambio getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(TipoCambio tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleVenta> getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}
	
	
}
