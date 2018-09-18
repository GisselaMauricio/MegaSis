package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Almacen;
import com.megacenter.dao.IAlmacenDAO;
import com.megacenter.service.IAlmacenService;

@Service
public class AlmacenServiceImpl implements IAlmacenService {

	@Autowired
	private IAlmacenDAO dao;

	@Override
	public Almacen registrar(Almacen almacen) {
		return dao.save(almacen);
	}

	@Override
	public void modificar(Almacen almacen) {
		dao.save(almacen);

	}

	@Override
	public void eliminar(int idAlmacen) {
		dao.deleteById(idAlmacen);

	}

	@Override
	public Almacen listar(int idAlmacen) {
		return dao.findById(idAlmacen).get();
	}

	@Override
	public List<Almacen> listar() {
		return dao.findAll();
	}

}
