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
		// TODO Auto-generated method stub
		return dao.save(sucursal);
	}

	@Override
	public void modificar(Sucursal sucursal) {
		// TODO Auto-generated method stub
		dao.save(sucursal);
	}

	@Override
	public void eliminar(int idSucursal) {
		// TODO Auto-generated method stub
		dao.deleteById(idSucursal);
	}

	@Override
	public Sucursal listarId(int idSucursal) {
		// TODO Auto-generated method stub
		return dao.getOne(idSucursal);
	}

	@Override
	public List<Sucursal> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
