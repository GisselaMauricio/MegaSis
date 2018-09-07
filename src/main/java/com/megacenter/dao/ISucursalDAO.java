package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Sucursal;

@Repository
public interface ISucursalDAO  extends JpaRepository<Sucursal, Integer>{

}
