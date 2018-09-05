package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.megacenter.Model.Proveedor;
import com.megacenter.dao.IProveedorDAO;
import com.megacenter.service.IProveedorService;

public class ProveedorServiceImpl implements IProveedorService {

	@Autowired
	private IProveedorDAO dao;
	@Override
	public Void registrar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return dao.save(proveedor);
	}

	@Override
	public void modificar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		dao.save(proveedor);
	}

	@Override
	public void eliminar(int idProveedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Proveedor listarId(int idProveedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proveedor> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
