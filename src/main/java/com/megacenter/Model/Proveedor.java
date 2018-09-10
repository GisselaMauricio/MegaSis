package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	@Id
	/*not exists operation on sqlite*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;

	@Column(name = "nombre", nullable = true, length = 70)
	private String nombre;

	@Column(name = "ruc", nullable = false, length = 11)
	private String ruc;

	@Column(name = "telefono", length = 9)
	private String telefono;

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
