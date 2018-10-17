package com.megacenter.dao;

import com.megacenter.Model.DetalleCompra;
import com.megacenter.Model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleCompraDAO extends JpaRepository<DetalleCompra, Integer>{

}
