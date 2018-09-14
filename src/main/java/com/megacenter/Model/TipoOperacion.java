package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoOperacion")
public class TipoOperacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoperacion;
	
	@Column(name = "nombre", nullable = false, precision = 11)
	private String nombre;
	
	@Column(name = "descripcion", nullable = false, precision = 30)
	private String descripcion;

	public int getIdTipoperacion() {
		return idTipoperacion;
	}

	public void setIdTipoperacion(int idTipoperacion) {
		this.idTipoperacion = idTipoperacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
