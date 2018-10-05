package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.Organizacion;

public interface IOrganizacionService {
	
	Organizacion registrar(Organizacion organizacion);

	void modificar(Organizacion organizacion);

	void eliminar(int idOrganizacion);

	Organizacion listarId(int idOrganizacion);

	List<Organizacion> listar();

}
