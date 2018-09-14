package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Venta;
import com.megacenter.dao.IVentaDAO;
import com.megacenter.service.IVentaService;
@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaDAO dao;
	@Override
	public Venta registrar(Venta venta) {
		// TODO Auto-generated method stub
		return dao.save(venta);
	}

	@Override
	public void modificar(Venta venta) {
		// TODO Auto-generated method stub
		dao.save(venta);
		
	}

	@Override
	public void eliminar(int idventa) {
		// TODO Auto-generated method stub
		dao.deleteById(idventa);
	}

	@Override
	public Venta listarId(int idventa) {
		
		return dao.getOne(idventa);
	}

	@Override
	public List<Venta> listar() {
		return dao.findAll();
	}

}
