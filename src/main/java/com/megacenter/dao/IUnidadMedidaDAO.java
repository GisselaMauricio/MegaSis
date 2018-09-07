package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.UnidadMedida;

@Repository
public interface IUnidadMedidaDAO extends JpaRepository<UnidadMedida, Integer> {

}
