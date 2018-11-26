package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megacenter.Model.Venta;
import org.springframework.data.jpa.repository.Query;

public interface IVentaDAO extends JpaRepository<Venta, Integer>{
    @Query(value = "select * from Venta m where m.id_tipocomprobante=?1 ORDER BY m.id_venta DESC LIMIT 1", nativeQuery = true)
    Venta getUltimoNumeroComprobante(int id);
}
