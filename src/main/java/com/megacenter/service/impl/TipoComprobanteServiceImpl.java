package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.TipoComprobante;
import com.megacenter.dao.ITipoComprobanteDAO;
import com.megacenter.service.ITipoComprobanteService;

@Service
public class TipoComprobanteServiceImpl implements ITipoComprobanteService {

	@Autowired
	private ITipoComprobanteDAO dao;

	@Override
	public void registar(TipoComprobante tipoComprobante) {
		dao.save(tipoComprobante);

	}

	@Override
	public void modificar(TipoComprobante tipoComprobante) {
		dao.save(tipoComprobante);

	}

	@Override
	public void eliminar(int idTipoComprobante) {
		dao.deleteById(idTipoComprobante);

	}

	@Override
	public TipoComprobante listarId(int idTipoComprobante) {
		return dao.findById(idTipoComprobante).get();
	}

	@Override
	public List<TipoComprobante> listar() {
		return dao.findAll();
	}

}
