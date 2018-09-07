package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unidadmedida")
public class UnidadMedida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUnidadMedida;

	@Column(name = "codUnidadMedida", nullable = false, length = 20)
	private String CodUnidadMedida;

	@Column(name = "descripcion", nullable = true, length = 50)
	private String Descripcion;

	public int getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(int idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	public String getCodUnidadMedida() {
		return CodUnidadMedida;
	}

	public void setCodUnidadMedida(String codUnidadMedida) {
		CodUnidadMedida = codUnidadMedida;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

}
