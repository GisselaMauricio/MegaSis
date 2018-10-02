package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.Categoria;

public interface ICategoriaService {

	void registrar(Categoria categoria);

	void actualizar(Categoria categoria);

	void eliminar(int idCategoria);

	Categoria listarId(int idCategoria);

	List<Categoria> listar();

}
