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
	private int idTipodocumento;

	@Column(name = "abreviatura", nullable = true, length = 20)
	private String abreviatura;

	@Column(name = "denominacion", nullable = true, length = 50)
	private String denominacion;

	public int getIdTipodocumento() {
		return idTipodocumento;
	}

	public void setIdTipodocumento(int idTipodocumento) {
		this.idTipodocumento = idTipodocumento;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

}
