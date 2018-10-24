package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Producto;

@Repository
public interface IProductoDAO extends JpaRepository<Producto, Integer> {
    Producto findProductoByCodProducto(String codigo);
	

}
