package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.TipoPago;
import com.megacenter.dao.ITipoPagoDAO;
import com.megacenter.service.ITipoPagoService;

@Service
public class TipoPagoServiceImpl implements ITipoPagoService {

	@Autowired
	private ITipoPagoDAO dao;
	@Override
	public TipoPago registrar(TipoPago tipoPago) {
		// TODO Auto-generated method stub
		return dao.save(tipoPago);
	}

	@Override
	public void modificar(TipoPago tipoPago) {
		dao.save(tipoPago);
		
	}

	@Override
	public void eliminar(int idTipoPago) {
		dao.deleteById(idTipoPago);
		
	}

	@Override
	public TipoPago listarId(int idTipoPago) {
		// TODO Auto-generated method stub
		return dao.getOne(idTipoPago);
	}

	@Override
	public List<TipoPago> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
