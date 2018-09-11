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
		compra.getDetalleCompra().forEach(x-> x.setCompra(compra));
		//for(Detallecompra det: compra.getDetalleCompra()){det.setCompra(consulta)}
		//return dao.save(compraDTO);
		
		//Compra com=new Compra();
		//compraDTO.getCompra().forEach(x-> x.setCompra(compraDTO.getCompra()));
		//com=dao.save(compraDTO.getCompra());		
		
		return dao.save(compra);
	}

	@Override
	public void modificar(Compra compra) {
		dao.save(compra);
		
	}

	@Override
	public void eliminar(int idCompra) {
		dao.deleteById(idCompra);
		
		
	}

	@Override
	public Compra listarId(int idCompra) {
		// TODO Auto-generated method stub
		return dao.getOne(idCompra);
	}
	
	@Override
	public List<Compra> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
