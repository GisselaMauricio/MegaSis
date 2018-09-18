package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megacenter.Model.Compra;
import com.megacenter.Model.DetalleCompra;
import com.megacenter.dao.ICompraDAO;
import com.megacenter.dao.IDetalleCompraDAO;
import com.megacenter.service.ICompraService;


@Service
public class CompraServiceImpl implements ICompraService{
	@Autowired
	private ICompraDAO dao;
	@Autowired
	private IDetalleCompraDAO dDAO;
	@Override
	public Compra registrar(Compra compra) {
		compra.getDetalleCompra().forEach(x-> x.setCompra(compra));
		return dao.save(compra);
		
	}
	

	@Override
	public void modificar(Compra compra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int idCompra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compra listarId(int idCompra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleCompra> listarDetallecompra(Integer idCompra) {
		// TODO Auto-generated method stub
		return dDAO.listarDetallecompra(idCompra);
	}


	
	

}
