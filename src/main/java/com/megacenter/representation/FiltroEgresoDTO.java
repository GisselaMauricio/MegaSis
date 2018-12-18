package com.megacenter.representation;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class FiltroEgresoDTO {

	private String benificiario;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaConsulta;

	public String getBenificiario() {
		return benificiario;
	}

	public void setBenificiario(String benificiario) {
		this.benificiario = benificiario;
	}

	public LocalDateTime getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(LocalDateTime fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

}
