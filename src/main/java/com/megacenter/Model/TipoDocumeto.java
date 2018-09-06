package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipodocumeto")
public class TipoDocumeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoDocumento;

	@Column(name = "abreviatura", nullable = true, length = 20)
	private String Abreviatura;

	@Column(name = "denominacion", nullable = true, length = 50)
	private String Denominacion;

	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getAbreviatura() {
		return Abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		Abreviatura = abreviatura;
	}

	public String getDenominacion() {
		return Denominacion;
	}

	public void setDenominacion(String denominacion) {
		Denominacion = denominacion;
	}

}
