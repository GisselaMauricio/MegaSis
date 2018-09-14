package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.Organizacion;
import com.megacenter.Model.Sucursal;




public interface IOrganizacionService {
	Organizacion registrar(Organizacion organizacion);
	void modificar(Organizacion organizacion);
	void eliminar (int idOrganizacion);
	Organizacion listarId(int idOrganizacion);
	List<Organizacion>listar();
	
	Sucursal registrarSu(Sucursal sucursal);
	void modificarSu(Sucursal sucursal);
	void eliminarSu (int idSucursal);
	Sucursal listarSuId(int idSucursal);
	List<Sucursal>listarSu();
	
}
