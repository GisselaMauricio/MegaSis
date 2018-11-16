package com.megacenter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Proforma;

@Repository
public interface IProformaDAO extends JpaRepository<Proforma, Integer> {

	@Query(value = "select * from Proforma m  ORDER BY m.id_proforma DESC LIMIT 1", nativeQuery = true)
	Proforma getLastProforma();
	
	@Query(value = "select id_proforma,acuenta, estado_proforma, numero_proforma from proforma", nativeQuery= true)
	List<Object[]> listarResumen();
}
