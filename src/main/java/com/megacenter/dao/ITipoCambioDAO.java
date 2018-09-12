package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.TipoCambio;

@Repository
public interface ITipoCambioDAO extends JpaRepository<TipoCambio, Integer> {

}
