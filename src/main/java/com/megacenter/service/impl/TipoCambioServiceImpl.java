package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.TipoCambio;
import com.megacenter.dao.ITipoCambioDAO;
import com.megacenter.service.ITipoCambioService;
@Service
public class TipoCambioServiceImpl implements ITipoCambioService{

	@Autowired
	private ITipoCambioDAO dao;
	@Override
	public TipoCambio registrar(TipoCambio tipoCambio) {
		// TODO Auto-generated method stub
		return dao.save(tipoCambio);
	}

	@Override
	public void modificar(TipoCambio tipoCambio) {
		dao.save(tipoCambio);
		
	}

	@Override
	public void eliminar(int idTipoCambio) {
		dao.deleteById(idTipoCambio);
		
	}

	@Override
	public TipoCambio listarId(int idTipoCambio) {
		// TODO Auto-generated method stub
		return dao.getOne(idTipoCambio);
	}

	@Override
	public List<TipoCambio> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
