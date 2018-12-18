package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Egreso;

@Repository
public interface IEgresoDAO extends JpaRepository<Egreso,Integer> {
	
//	@Query("from egreso c where c.fecha between :fechaConsulta and :fechaSgte")
//	List<Egreso> buscarPorFecha(@Param("fechaConsulta") LocalDateTime fechaConsulta, @Param("fechaSgte") LocalDateTime fechaSgte);
//	
}
