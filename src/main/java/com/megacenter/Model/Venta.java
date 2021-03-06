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
	
	@Column(name = "estadoVenta", nullable = true )
	private Double estadoVenta;

	@Column(name = "serieComprobante", nullable = false,  length = 10)
	private String serieComprobante;

	@Column(name = "numeroComprobante", nullable = false, length = 10)
	private String numeroComprobante;

	@OneToOne
	@JoinColumn(name = "id_tipocambio", nullable = false)
	private TipoCambio tipocambio;

	@OneToOne
	@JoinColumn(name = "id_tipopago", nullable = false)
	private TipoPago tipopago;

	@OneToOne
	@JoinColumn(name = "id_tipocomprobante", nullable = false)
	private TipoComprobante tipocomprobante;
	
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


	public String getSerieComprobante() {
		return serieComprobante;
	}

	public void setSerieComprobante(String serieComprobante) {
		this.serieComprobante = serieComprobante;
	}

	public String getNumeroComprobante() {
		return numeroComprobante;
	}

	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}

	public TipoComprobante getTipocomprobante() {
		return tipocomprobante;
	}

	public void setTipocomprobante(TipoComprobante tipocomprobante) {
		this.tipocomprobante = tipocomprobante;
	}

    public TipoCambio getTipocambio() {
        return tipocambio;
    }

    public void setTipocambio(TipoCambio tipocambio) {
        this.tipocambio = tipocambio;
    }

    public TipoPago getTipopago() {
        return tipopago;
    }

    public void setTipopago(TipoPago tipopago) {
        this.tipopago = tipopago;
    }
}
