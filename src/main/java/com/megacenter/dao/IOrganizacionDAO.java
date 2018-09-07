package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Organizacion;

@Repository
public interface IOrganizacionDAO  extends JpaRepository<Organizacion, Integer>{

}
