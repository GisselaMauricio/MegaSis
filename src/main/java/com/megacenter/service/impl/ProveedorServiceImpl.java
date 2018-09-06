package com.megacenter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Proveedor;
import com.megacenter.dao.IProveedorDAO;
import com.megacenter.service.IProveedorService;

@Service
public class ProveedorServiceImpl implements IProveedorService  {

	@Autowired	
	private IProveedorDAO dao;

	@Override
	public void registrar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		proveedor=dao.save(proveedor);
	}

	@Override
	public void modificar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		dao.save(proveedor);
	}

	@Override
	public void eliminar(int idProveedor) {
		dao.deleteById(idProveedor);

	}

	@Override
	public Proveedor listarId(int idProveedor) {
		// TODO Auto-generated method stub
		return dao.findById(idProveedor).get();
	}

	@Override
	public List<Proveedor> listar() {
		// TODO Auto-generated method stub
		return  dao.findAll();
	}

	
	
	


}
