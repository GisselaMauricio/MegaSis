package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.Producto;

public interface IProductoService {

	Producto registrar(Producto producto);
	Producto busar(String a);

	void modificar(Producto producto);

	void eliminar(int idProducto);

	Producto listarId(int idProducto);

	List<Producto> listar();
}
