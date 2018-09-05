package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Compra;
import com.megacenter.dao.ICompraDAO;
import com.megacenter.service.ICompraService;
@Service
public class CompraServiceImpl implements ICompraService{

	@Autowired
	private ICompraDAO dao;
	@Override
	public Compra registrar(Compra compra) {
		
		return dao.save(compra);
	}

	@Override
	public void modificar(Compra compra) {
		dao.save(compra);
		
	}

	@Override
	public void eliminar(int idCompra) {
		dao.delete(idCompra);
		
		
	}

	@Override
	public Compra listarId(int idCompra) {
		// TODO Auto-generated method stub
		return dao.findOne(idCompra);
	}

	@Override
	public List<Compra> list() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
