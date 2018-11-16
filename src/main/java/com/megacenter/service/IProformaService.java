package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.Proforma;
import com.megacenter.representation.ConsultaListProforma;

public interface IProformaService {

	Proforma registrar(Proforma proforma);

	void modificar(Proforma proforma);

	void eliminar(int idProforma);

	Proforma listarId(int idProforma);

	Proforma getLastProforma();

	List<Proforma> listar();

	List<ConsultaListProforma> listarResumen();

	byte[] generarReporte();
}
