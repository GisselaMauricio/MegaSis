package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Persona;

@Repository
public interface IPersonaDAO extends JpaRepository<Persona, Integer> {

}
