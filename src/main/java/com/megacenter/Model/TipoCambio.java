package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tipocambio")
public class TipoCambio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipocambio;
	@Column(name = "nombre", nullable = true, length = 20)
	private String nombre;
	public int getIdTipocambio() {
		return idTipocambio;
	}
	public void setIdTipocambio(int idTipocambio) {
		this.idTipocambio = idTipocambio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
