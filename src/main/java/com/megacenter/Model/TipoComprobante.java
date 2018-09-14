package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipocomprobante")
public class TipoComprobante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipocomprobante;

	@Column(name = "codTipocomprobante", nullable = false, length = 3)
	private String codTipocomprobante;

	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;

	public int getIdTipocomprobante() {
		return idTipocomprobante;
	}

	public void setIdTipocomprobante(int idTipocomprobante) {
		this.idTipocomprobante = idTipocomprobante;
	}

	public String getCodTipocomprobante() {
		return codTipocomprobante;
	}

	public void setCodTipocomprobante(String codTipocomprobante) {
		this.codTipocomprobante = codTipocomprobante;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
