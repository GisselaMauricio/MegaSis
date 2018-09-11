package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.Persona;

public interface IPersonaService {
	
	Persona registrar(Persona persona);

	void modificar(Persona persona);

	void eliminar(int idPersona);

	Persona listar(int idPersona);

	List<Persona> listar();
}
