package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.UnidadMedida;

public interface IUnidadMedidaService {

	void registrar(UnidadMedida unidadMedida);

	void modificar(UnidadMedida unidadMedida);

	void eliminar(int idUnidadMedida);

	UnidadMedida listarId(int idUnidadMedida);

	List<UnidadMedida> listar();
}
