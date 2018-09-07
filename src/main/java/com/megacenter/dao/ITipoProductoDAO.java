package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.TipoProducto;

@Repository
public interface ITipoProductoDAO extends JpaRepository<TipoProducto, Integer> {

}
