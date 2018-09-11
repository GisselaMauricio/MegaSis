package com.megacenter.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "personal")
public class Personal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersonal;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaIngreso;

	@Column(name = "sueldo", nullable = false, precision = 11, scale = 2)
	private double sueldo;

	@OneToOne
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;
	// id_Personal

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
