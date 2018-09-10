package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "organizacion")
public class Organizacion {
@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int idOrganizacion;

@Column(name = "nombreComercial", nullable = true, length = 70)
private String nombreComercial;

@Column(name = "razonSocial", nullable = true, length = 70)
private String razonSocial;

@Column(name = "ruc", nullable = false, length = 8)
private String ruc;

@Column(name = "telefono", length = 9)
private String telefono;
@Column(name = "email", nullable = true,length = 30)
private String email;

@Column(name = "direccion", length = 20)
private String direccion;


public int getIdOrganizacion() {
	return idOrganizacion;
}

public void setIdOrganizacion(int idOrganizacion) {
	this.idOrganizacion = idOrganizacion;
}

public String getNombreComercial() {
	return nombreComercial;
}

public void setNombreComercial(String nombreComercial) {
	this.nombreComercial = nombreComercial;
}

public String getRazonSocial() {
	return razonSocial;
}

public void setRazonSocial(String razonSocial) {
	this.razonSocial = razonSocial;
}

public String getRuc() {
	return ruc;
}

public void setRuc(String ruc) {
	this.ruc = ruc;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}



}
