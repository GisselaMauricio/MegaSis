package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Persona;
import com.megacenter.dao.IPersonaDAO;
import com.megacenter.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDAO dao;

	@Override
	public Persona registrar(Persona persona) {
		return dao.save(persona);
	}

	@Override
	public Persona modificar(Persona persona) {
		return dao.save(persona);

	}

	@Override
	public void eliminar(int idPersona) {
		dao.deleteById(idPersona);
	}

	@Override
	public List<Persona> listar() {
		return dao.findAll();
	}

	@Override
	public Persona listarId(int idPersona) {
		// TODO Auto-generated method stub
		return dao.findById(idPersona).get();
	}

}
