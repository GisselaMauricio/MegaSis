package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.TipoComprobante;

public interface ITipoComprobanteService {

	void registar(TipoComprobante tipoComprobante);

	void modificar(TipoComprobante tipoComprobante);

	void eliminar(int idTipoComprobante);

	TipoComprobante listarId(int idTipoComprobante);

	List<TipoComprobante> listar();
}
