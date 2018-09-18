package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Almacen;

@Repository
public interface IAlmacenDAO extends JpaRepository<Almacen, Integer> {

}
