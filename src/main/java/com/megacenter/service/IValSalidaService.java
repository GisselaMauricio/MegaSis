package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.ValSalida;

public interface IValSalidaService {

	ValSalida registrar(ValSalida valSalida);

	void modificar(ValSalida valSalida);

	void eliminar(int idValSalida);

	ValSalida listar(int idValSalida);

	List<ValSalida> listar();
}
