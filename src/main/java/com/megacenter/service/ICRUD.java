package com.megacenter.service;

import java.util.List;


public interface ICRUD <T> {
	T registrar(T t);
	void modificar(T t);
	void eliminar (int id);
	T listarId(int id);
	List<T>listar();
	
	
	
	
	
}
