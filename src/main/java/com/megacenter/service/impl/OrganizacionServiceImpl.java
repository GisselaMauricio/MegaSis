package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Organizacion;
import com.megacenter.dao.IOrganizacionDAO;
import com.megacenter.service.IOrganizacionService;
@Service
public class OrganizacionServiceImpl implements IOrganizacionService{

	@Autowired	
	private IOrganizacionDAO dao;
	@Override
	public Organizacion registrar(Organizacion organizacion) {
		// TODO Auto-generated method stub
		return dao.save(organizacion);
	}

	@Override
	public void modificar(Organizacion organizacion) {
		// TODO Auto-generated method stub
		dao.save(organizacion);
	}

	@Override
	public void eliminar(int idOrganizacion) {
		// TODO Auto-generated method stub
		dao.deleteById(idOrganizacion);
	}

	@Override
	public Organizacion listarId(int idOrganizacion) {
		// TODO Auto-generated method stub
		return dao.getOne(idOrganizacion);
	}

	@Override
	public List<Organizacion> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
