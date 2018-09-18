package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.ValEntrada;
import com.megacenter.dao.IValEntradaDAO;
import com.megacenter.service.IValEntradaService;

@Service
public class ValEntradaServiceImpl implements IValEntradaService {

	@Autowired
	private IValEntradaDAO dao;

	@Override
	public ValEntrada registrar(ValEntrada valEntrada) {
		return dao.save(valEntrada);
	}

	@Override
	public void modificar(ValEntrada valEntrada) {
		dao.save(valEntrada);

	}

	@Override
	public void eliminar(int idValEntrada) {
		dao.deleteById(idValEntrada);

	}

	@Override
	public ValEntrada listar(int idValEntrada) {
		return dao.findById(idValEntrada).get();
	}

	@Override
	public List<ValEntrada> listar() {
		return dao.findAll();
	}

}
