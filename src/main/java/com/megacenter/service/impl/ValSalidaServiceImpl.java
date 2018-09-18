package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.ValSalida;
import com.megacenter.dao.IValSalidaDAO;
import com.megacenter.service.IValSalidaService;

@Service
public class ValSalidaServiceImpl implements IValSalidaService {

	@Autowired
	private IValSalidaDAO dao;

	@Override
	public ValSalida registrar(ValSalida valSalida) {
		return dao.save(valSalida);
	}

	@Override
	public void modificar(ValSalida valSalida) {
		dao.save(valSalida);

	}

	@Override
	public void eliminar(int idValSalida) {
		dao.deleteById(idValSalida);

	}

	@Override
	public ValSalida listar(int idValSalida) {
		return dao.findById(idValSalida).get();
	}

	@Override
	public List<ValSalida> listar() {
		return dao.findAll();
	}

}
