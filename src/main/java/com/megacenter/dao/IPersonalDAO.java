package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Persona;
import com.megacenter.Model.Personal;

@Repository
public interface IPersonalDAO extends JpaRepository<Personal, Integer> {

}
