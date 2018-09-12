package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.DetalleCompra;

public interface IDetalleCompraService {
	DetalleCompra registrar(DetalleCompra detalleCompra);
	void modificar(DetalleCompra detalleCompra);
	void eliminar (int idDetalleCompra);
	DetalleCompra listarId(int idDetalleCompra);
	List<DetalleCompra>listar();
}
