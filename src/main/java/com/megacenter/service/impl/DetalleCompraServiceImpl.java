package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.DetalleCompra;
import com.megacenter.dao.IDetalleCompraDAO;
import com.megacenter.service.IDetalleCompraService;
@Service
public class DetalleCompraServiceImpl implements IDetalleCompraService{

	@Autowired
	private IDetalleCompraDAO dao;
	
	@Override
	public DetalleCompra registrar(DetalleCompra detalleCompra) {
		// TODO Auto-generated method stub
		return dao.save(detalleCompra);
	}

	@Override
	public void modificar(DetalleCompra detalleCompra) {
		// TODO Auto-generated method stub
		dao.save(detalleCompra);
		
	}

	@Override
	public void eliminar(int idDetalleCompra) {
		// TODO Auto-generated method stub}
		dao.deleteById(idDetalleCompra);
		
	}

	@Override
	public DetalleCompra listarId(int idDetalleCompra) {
		// TODO Auto-generated method stub
		return dao.getOne(idDetalleCompra);
	}

	@Override
	public List<DetalleCompra> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
