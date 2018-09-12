package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipopago")
public class TipoPago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipopago;
	@Column(name = "nombre", nullable = true, length = 20)
	private String nombre;
	@Column(name = "descripcion", nullable = true, length = 20)
	private String descripcion;

	public int getIdTipopago() {
		return idTipopago;
	}

	public void setIdTipopago(int idTipopago) {
		this.idTipopago = idTipopago;
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
