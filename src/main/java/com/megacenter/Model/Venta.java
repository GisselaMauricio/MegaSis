package com.megacenter.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
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
	
	//id_Cliente
	//id_Personal
	//id_ComprobantePago
	
	
}
