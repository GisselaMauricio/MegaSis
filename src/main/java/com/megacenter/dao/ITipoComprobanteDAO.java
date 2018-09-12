package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.TipoComprobante;

@Repository
public interface ITipoComprobanteDAO extends JpaRepository<TipoComprobante, Integer> {

}
