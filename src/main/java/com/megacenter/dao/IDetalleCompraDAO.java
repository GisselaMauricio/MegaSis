package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.megacenter.Model.DetalleCompra;
@Repository
public interface IDetalleCompraDAO extends JpaRepository<DetalleCompra, Integer>{
	
	//@Transactional	
	@Modifying
	@Query(value="INSERT INTO detalle_compra(id_compra, id_producto) VALUES(:idCompra,:idProducto)", nativeQuery=true)
int registrar(@Param ("idCompra")Integer idCompra, @Param ("idProducto")Integer idProducto);
}
