package com.megacenter.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(DetalleCompraPK.class)
public class DetalleCompra {

	@Id
	private Producto producto;
	@Id
	private Compra compra;
	
	}
