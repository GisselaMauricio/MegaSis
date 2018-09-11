package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.Cliente;

public interface IClienteService {

	Cliente registrar(Cliente cliente);

	void modificar(Cliente cliente);

	void eliminar(int idCliente);

	Cliente listar(int idCliente);

	List<Cliente> listar();
}