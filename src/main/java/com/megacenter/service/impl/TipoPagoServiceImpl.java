package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.ITipoPagoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.TipoPago;
import com.megacenter.service.ITipoPagoService;

@Service
public class TipoPagoServiceImpl implements ITipoPagoService{

	@Autowired
	private ITipoPagoDAO dao;
	@Override
	public TipoPago registrar(TipoPago pago) {
		return  dao.save(pago);
	}

	@Override
	public void modificar(TipoPago pago) {
		dao.save(pago);
		
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public TipoPago listarId(int id) {
		return dao.findById(id).get();
	}

	@Override
	public List<TipoPago> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
