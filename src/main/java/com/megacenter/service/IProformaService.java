package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.Proforma;

public interface IProformaService {

	Proforma registrar(Proforma proforma);

	void modificar(Proforma proforma);

	void eliminar(int idProforma);

	Proforma listar(int idProforma);

	List<Proforma> listar();
}
