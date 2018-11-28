package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.Model.DetalleVenta;
import com.megacenter.dao.IDetalleVentaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Venta;
import com.megacenter.dao.IVentaDAO;
import com.megacenter.service.IVentaService;
@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaDAO dao;
	@Autowired
	private IDetalleVentaDAO detalle;
	@Override
	public Venta registrar(Venta venta) {
		Venta vs = dao.save(venta);
		for (DetalleVenta detalleVenta : vs.getDetalleVenta()) {
			detalleVenta.setVenta(vs);
			detalle.save(detalleVenta);
		}
		return vs;
	}

	@Override
	public void modificar(Venta venta) {
		dao.save(venta);
	}

	@Override
	public void eliminar(int idventa) {
		dao.deleteById(idventa);
	}

	@Override
	public Venta listarId(int idventa) {
		return dao.findById(idventa).get();
	}

	@Override
	public List<Venta> listar() {
		return dao.findAll();
	}


	@Override
	public Venta getUltimoNumeroComprobante(int Id) {
		return dao.getUltimoNumeroComprobante(Id);
	}
}
