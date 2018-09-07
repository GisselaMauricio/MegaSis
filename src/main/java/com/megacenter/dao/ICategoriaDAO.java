package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Categoria;

@Repository
public interface ICategoriaDAO extends JpaRepository<Categoria, Integer> {

}
