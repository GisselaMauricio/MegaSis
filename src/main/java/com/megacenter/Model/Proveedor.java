package com.megacenter.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;

	@Column(name = "nombreComercial", nullable = false, length = 100)
	private String nombreComercial;

	@Column(name = "razonSocial", nullable = false, length = 50)
	private String razonSocial;

	@Column(name = "paginaWeb", nullable = true, length = 50)
	private String paginaWeb;

	@Column(name = "telefonoEmpresa", nullable = true, length = 9)
	private String telfEmpresa;

	@OneToOne
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
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

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getTelfEmpresa() {
		return telfEmpresa;
	}

	public void setTelfEmpresa(String telfEmpresa) {
		this.telfEmpresa = telfEmpresa;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
