package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sucrusal")
public class Sucursal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSocursal;

	@Column(name = "nombre", nullable = true, length = 100)
	private String nombre;

	@Column(name = "direccion", nullable = true, length = 100)
	private String direccion;

	//@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_organizacion", nullable = false)
	//private Organizacion organizacion;
	@ManyToOne
	@JoinColumn(name = "id_organizacion", nullable = false)
	private Organizacion organizacion;

	public int getIdSocursal() {
		return idSocursal;
	}

	public void setIdSocursal(int idSocursal) {
		this.idSocursal = idSocursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

	

	
}
