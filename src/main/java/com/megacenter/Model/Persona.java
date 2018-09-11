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
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "numeroDocumento", nullable = false, length = 12)
	private String numeroDocumento;

	@Column(name = "telfMovil", nullable = true, length = 9)
	private String telfMovil;

	@Column(name = "direccion", nullable = true, length = 100)
	private String direccion;

	@Column(name = "email", nullable = true, length = 50)
	private String email;

	@OneToOne
	@JoinColumn(name = "id_Tipodocumento", nullable = false)
	private TipoDocumeto tipoDocumeto;

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTelfMovil() {
		return telfMovil;
	}

	public void setTelfMovil(String telfMovil) {
		this.telfMovil = telfMovil;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoDocumeto getTipoDocumeto() {
		return tipoDocumeto;
	}

	public void setTipoDocumeto(TipoDocumeto tipoDocumeto) {
		this.tipoDocumeto = tipoDocumeto;
	}

}
