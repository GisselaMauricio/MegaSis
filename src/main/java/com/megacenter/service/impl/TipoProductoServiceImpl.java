package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.TipoProducto;
import com.megacenter.dao.ITipoProductoDAO;
import com.megacenter.service.ITipoProductoService;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService {

	@Autowired
	private ITipoProductoDAO dao;

	@Override
	public void registrar(TipoProducto tipoProducto) {
		dao.save(tipoProducto);

	}

	@Override
	public void actualizar(TipoProducto tipoProducto) {
		dao.save(tipoProducto);
	}

	@Override
	public void eliminar(int idTipoProducto) {
		dao.deleteById(idTipoProducto);

	}

	@Override
	public TipoProducto listarId(int idTipoProducto) {
		return dao.findById(idTipoProducto).get();
	}

	@Override
	public List<TipoProducto> listar() {
		return dao.findAll();
	}

}
