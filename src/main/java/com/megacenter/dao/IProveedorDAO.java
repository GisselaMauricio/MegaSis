package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Proveedor;
@Repository
public interface IProveedorDAO extends JpaRepository<Proveedor, Integer> {

}
