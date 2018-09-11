package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.Persona;
import com.megacenter.Model.Personal;

public interface IPersonalService {

	Personal registrar(Personal personal);

	void modificar(Personal personal);

	void eliminar(int idPersonal);

	Personal listar(int idPersonal);

	List<Personal> listar();
}
