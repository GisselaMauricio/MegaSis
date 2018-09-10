package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Producto;
import com.megacenter.dao.IProductoDAO;
import com.megacenter.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDAO dao;

	@Override
	public Producto registrar(Producto producto) {
		return dao.save(producto);
	}

	@Override
	public void modificar(Producto producto) {
		dao.save(producto);

	}

	@Override
	public void eliminar(int idProducto) {
		dao.deleteById(idProducto);

	}

	@Override
	public Producto listar(int idProducto) {
		return dao.findById(idProducto).get();
	}

	@Override
	public List<Producto> listar() {
		return dao.findAll();
	}

}
