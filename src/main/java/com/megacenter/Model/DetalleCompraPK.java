package com.megacenter.Model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class DetalleCompraPK {
@ManyToOne
@JoinColumn(name="idProducto", nullable=false)
private Producto producto;

@ManyToOne
@JoinColumn(name="idCompra", nullable=false)
private Compra compra;

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((compra == null) ? 0 : compra.hashCode());
	result = prime * result + ((producto == null) ? 0 : producto.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DetalleCompraPK other = (DetalleCompraPK) obj;
	if (compra == null) {
		if (other.compra != null)
			return false;
	} else if (!compra.equals(other.compra))
		return false;
	if (producto == null) {
		if (other.producto != null)
			return false;
	} else if (!producto.equals(other.producto))
		return false;
	return true;
}
}
