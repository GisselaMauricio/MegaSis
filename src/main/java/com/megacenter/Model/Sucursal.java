package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sucrusal")
public class Sucursal {
	
	@Id
	private int idSocursal;
	
	@Column(name = "nombre", nullable = true, length = 70)
	private String nombre;
	
	@Column(name = "direccion", nullable = true, length = 70)
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name="id_Organizacion", nullable=false)
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
