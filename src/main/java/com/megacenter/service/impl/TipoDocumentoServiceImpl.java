package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.TipoDocumeto;
import com.megacenter.dao.ITipoDocumentoDAO;
import com.megacenter.service.ITipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {

	@Autowired
	private ITipoDocumentoDAO dao;

	@Override
	public void registrar(TipoDocumeto tipoDocumeto) {
		dao.save(tipoDocumeto);

	}

	@Override
	public void modificar(TipoDocumeto tipoDocumeto) {
		dao.save(tipoDocumeto);

	}

	@Override
	public void eliminar(int idTipoDocumeto) {
		dao.deleteById(idTipoDocumeto);

	}

	@Override
	public TipoDocumeto listarId(int idTipoDocumeto) {
		return dao.findById(idTipoDocumeto).get();
	}

	@Override
	public List<TipoDocumeto> listar() {
		return dao.findAll();
	}

}
