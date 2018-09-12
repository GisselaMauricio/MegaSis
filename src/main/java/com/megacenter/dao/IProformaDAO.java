package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Proforma;

@Repository
public interface IProformaDAO extends JpaRepository<Proforma, Integer> {

}
