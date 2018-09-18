package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.ValEntrada;

@Repository
public interface IValEntradaDAO extends JpaRepository<ValEntrada, Integer> {

}
