package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Compra;

@Repository
public interface ICompraDAO extends JpaRepository<Compra, Integer> {

	

}
