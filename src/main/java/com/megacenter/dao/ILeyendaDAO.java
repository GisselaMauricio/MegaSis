package com.megacenter.dao;

import com.megacenter.Model.Leyenda;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ILeyendaDAO extends JpaRepository<Leyenda, Integer> {
}
