package com.megacenter.representation;

import java.math.BigDecimal;

public class ConsultaListProforma {
	// select id_proforma, acuenta, estado_proforma, numero_proforma, saldo, total
	// from proforma

	private int id_proforma;
	private BigDecimal acuenta;
	private String estado_proforma;
	private String numero_proforma;
	// private double saldo;
	// private double total;
    //POR NO QUIRES

	public ConsultaListProforma() {
		// TODO Auto-generated constructor stub
	}

	public ConsultaListProforma(int id_proforma, BigDecimal acuenta, String estado_proforma, String numero_proforma) {
		super();
		this.id_proforma = id_proforma;
		this.acuenta = acuenta;
		this.estado_proforma = estado_proforma;
		this.numero_proforma = numero_proforma;
	}

	public int getId_proforma() {
		return id_proforma;
	}

	public void setId_proforma(int id_proforma) {
		this.id_proforma = id_proforma;
	}

	public BigDecimal getAcuenta() {
		return acuenta;
	}

	public void setAcuenta(BigDecimal acuenta) {
		this.acuenta = acuenta;
	}

	public String getEstado_proforma() {
		return estado_proforma;
	}

	public void setEstado_proforma(String estado_proforma) {
		this.estado_proforma = estado_proforma;
	}

	public String getNumero_proforma() {
		return numero_proforma;
	}

	public void setNumero_proforma(String numero_proforma) {
		this.numero_proforma = numero_proforma;
	}

}
