package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megacenter.Model.TipoOperacion;

public interface ITipoOperacionDAO extends JpaRepository<TipoOperacion, Integer>{

}
