package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.ValEntrada;

public interface IValEntradaService {

	ValEntrada registrar(ValEntrada valEntrada);

	void modificar(ValEntrada valEntrada);

	void eliminar(int idValEntrada);

	ValEntrada listar(int idValEntrada);

	List<ValEntrada> listar();
}
