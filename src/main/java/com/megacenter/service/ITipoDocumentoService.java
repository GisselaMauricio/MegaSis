package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.TipoDocumeto;

public interface ITipoDocumentoService {

	void registrar(TipoDocumeto tipoDocumeto);

	void modificar(TipoDocumeto tipoDocumeto);

	void eliminar(int idTipoDocumeto);

	TipoDocumeto listarId(int idTipoDocumeto);

	List<TipoDocumeto> listar();

}
