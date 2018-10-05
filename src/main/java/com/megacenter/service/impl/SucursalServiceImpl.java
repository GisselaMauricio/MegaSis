package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Sucursal;
import com.megacenter.dao.ISucursalDAO;
import com.megacenter.service.ISucursalService;

@Service
public class SucursalServiceImpl implements ISucursalService {
	
	@Autowired
	private ISucursalDAO dao;

	@Override
	public Sucursal registrar(Sucursal sucursal) {
		return dao.save(sucursal);
	}

	@Override
	public void modificar(Sucursal sucursal) {
		dao.save(sucursal);
		
	}

	@Override
	public void eliminar(int idSucursal) {
	dao.deleteById(idSucursal);
		
	}

	@Override
	public Sucursal listarId(int idSucursal) {
		return dao.findById(idSucursal).get();
	}

	@Override
	public List<Sucursal> listar() {
		return dao.findAll();
	}

}
