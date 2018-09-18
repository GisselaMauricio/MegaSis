package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.DetalleVenta;
import com.megacenter.dao.IDetalleVentaDAO;
import com.megacenter.service.IDetalleVentaService;
@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {

	@Autowired
	private IDetalleVentaDAO dao;
	@Override
	public DetalleVenta registrar(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		return dao.save(detalleVenta);
	}

	@Override
	public void modificar(DetalleVenta detalleVenta) {
		dao.save(detalleVenta);
		
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public DetalleVenta listarId(int id) {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}

	@Override
	public List<DetalleVenta> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
