package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Personal;
import com.megacenter.dao.IPersonalDAO;
import com.megacenter.service.IPersonalService;

@Service
public class PersonalServiceImpl implements IPersonalService {

	@Autowired
	private IPersonalDAO dao;

	@Override
	public Personal registrar(Personal personal) {
		return dao.save(personal);
	}

	@Override
	public void modificar(Personal personal) {
		dao.save(personal);

	}

	@Override
	public void eliminar(int idPersonal) {
		dao.deleteById(idPersonal);

	}

	@Override
	public Personal listar(int idPersonal) {
		return dao.findById(idPersonal).get();
	}

	@Override
	public List<Personal> listar() {
		return dao.findAll();
	}

}
