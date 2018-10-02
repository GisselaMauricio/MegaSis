package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.TipoProducto;

public interface ITipoProductoService {

	void registrar(TipoProducto tipoProducto);

	void actualizar(TipoProducto tipoProducto);

	void eliminar(int idTipoProducto);

	TipoProducto listarId(int idTipoProducto);

	List<TipoProducto> listar();

}
