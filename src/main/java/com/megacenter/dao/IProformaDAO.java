package com.megacenter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.megacenter.Model.Proforma;

@Repository
public interface IProformaDAO extends JpaRepository<Proforma, Integer> {

	@Query(value = "select * from Proforma m  ORDER BY m.id_proforma DESC LIMIT 1", nativeQuery = true)
	Proforma getLastProforma();
	
	@Query(value = "select id_proforma,acuenta, estado_proforma, numero_proforma from proforma", nativeQuery= true)
	List<Object[]> listarResumen();
	
	@Query(value = "select b.cantidaditem,d.descripcion,c.nombre,b.precioitem, b.importetotalitem from proforma a inner join detalle_proforma b on a.id_proforma=b.id_proforma inner join producto c on b.id_producto=c.id_producto inner join unidadmedida d on c.id_unidadmedida=d.id_unidadmedida where a.numero_proforma=:numeroProforma", nativeQuery= true)
	List<Object[]> listarDetalleProforma(@Param("numeroProforma") String numeroProforma);
}
