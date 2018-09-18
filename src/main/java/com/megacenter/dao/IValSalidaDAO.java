package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.ValSalida;

@Repository
public interface IValSalidaDAO extends JpaRepository<ValSalida, Integer> {

}
