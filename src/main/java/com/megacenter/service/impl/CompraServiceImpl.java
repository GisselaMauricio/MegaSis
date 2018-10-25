package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.Model.DetalleCompra;
import com.megacenter.dao.IDetalleCompraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Compra;
import com.megacenter.dao.ICompraDAO;
import com.megacenter.service.ICompraService;


@Service
public class CompraServiceImpl implements ICompraService {
    @Autowired
    private ICompraDAO dao;
    @Autowired
    private IDetalleCompraDAO detalle;
/*ghohllhlhlhlhl*/
    @Override
    public Compra registrar(Compra compra) {
        Compra cs = dao.save(compra);
        for (DetalleCompra detalleCompra : cs.getDetalleCompra()) {
            detalleCompra.setCompra(cs);
            detalle.save(detalleCompra);
        }
        return cs;
    }

    @Override
    public void modificar(Compra compra) {
        dao.save(compra);

    }

    @Override
    public void eliminar(int idCompra) {
        dao.deleteById(idCompra);

    }

    @Override
    public Compra listarId(int idCompra) {
        return dao.findById(idCompra).get();
    }

    @Override
    public List<Compra> listar() {
        return dao.findAll();
    }


}
