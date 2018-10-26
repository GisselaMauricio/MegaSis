package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Proforma;
import com.megacenter.dao.IProformaDAO;
import com.megacenter.service.IProformaService;

@Service
public class ProformaServiceImpl implements IProformaService	 {

	@Autowired
	private IProformaDAO dao;

	@Override
	public Proforma registrar(Proforma proforma) {
		proforma.getDetalleProforma().forEach(x -> x.setProforma(proforma));
		return dao.save(proforma);
	}

	@Override
	public void modificar(Proforma proforma) {
		dao.save(proforma);

	}

	@Override
	public void eliminar(int idProforma) {
		dao.deleteById(idProforma);

	}

	@Override
	public Proforma listarId(int idProforma) {
		return dao.findById(idProforma).get();
	}

	@Override
	public List<Proforma> listar() {
		return dao.findAll();
	}

	@Override
	public Proforma getLastProforma() {
		return dao.getLastProforma();
	}

}
