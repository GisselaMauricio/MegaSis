package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.Almacen;

public interface IAlmacenService {

	Almacen registrar(Almacen almacen);

	void modificar(Almacen almacen);

	void eliminar(int idAlmacen);

	Almacen listar(int idAlmacen);

	List<Almacen> listar();
}
