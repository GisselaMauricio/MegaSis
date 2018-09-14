package com.megacenter.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "cronogramapago")
public class CronogramaPago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCronogramapago;
	
	@Column(name = "nroCuota", nullable = false, precision = 10 )
	private String nroCuota;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaInicio;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaPago;
	
	@Column(name = "MontoTotal", nullable = false, precision = 11, scale = 2)
	private Double montoTotal;
	
	@OneToOne
	@JoinColumn(name = "id_venta", nullable = false)
	private Venta venta;

	public int getIdCronogramapago() {
		return idCronogramapago;
	}

	public void setIdCronogramapago(int idCronogramapago) {
		this.idCronogramapago = idCronogramapago;
	}

	public String getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(String nroCuota) {
		this.nroCuota = nroCuota;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
		
	//Pago_Couta
	
}
