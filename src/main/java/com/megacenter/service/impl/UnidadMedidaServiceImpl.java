package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.UnidadMedida;
import com.megacenter.dao.IUnidadMedidaDAO;
import com.megacenter.service.IUnidadMedidaService;

@Service
public class UnidadMedidaServiceImpl implements IUnidadMedidaService {

	@Autowired
	private IUnidadMedidaDAO dao;

	@Override
	public void registrar(UnidadMedida unidadMedida) {
		dao.save(unidadMedida);

	}

	@Override
	public void modificar(UnidadMedida unidadMedida) {
		dao.save(unidadMedida);

	}

	@Override
	public void eliminar(int idUnidadMedida) {
		dao.deleteById(idUnidadMedida);

	}

	@Override
	public UnidadMedida listarId(int idUnidadMedida) {
		return dao.findById(idUnidadMedida).get();
	}

	@Override
	public List<UnidadMedida> listar() {
		return dao.findAll();
	}

}
