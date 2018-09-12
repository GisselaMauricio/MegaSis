package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.TipoPago;
@Repository
public interface ITipoPagoDAO extends JpaRepository<TipoPago, Integer>{

}
