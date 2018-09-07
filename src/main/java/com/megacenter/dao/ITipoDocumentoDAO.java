package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.TipoDocumeto;

@Repository
public interface ITipoDocumentoDAO extends JpaRepository<TipoDocumeto, Integer> {

}
