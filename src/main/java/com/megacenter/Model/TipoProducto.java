package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoproducto")
public class TipoProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoproducto;

	@Column(name = "descripcion", nullable = true, length = 50)
	private String descripcion;

	public int getIdTipoproducto() {
		return idTipoproducto;
	}

	public void setIdTipoproducto(int idTipoproducto) {
		this.idTipoproducto = idTipoproducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
