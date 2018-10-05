package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.Sucursal;

public interface ISucursalService {

	Sucursal registrar(Sucursal sucursal);

	void modificar(Sucursal sucursal);

	void eliminar(int idSucursal);

	Sucursal listarId(int idSucursal);

	List<Sucursal> listar();

}
