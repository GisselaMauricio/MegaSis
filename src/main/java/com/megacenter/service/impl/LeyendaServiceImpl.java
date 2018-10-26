package com.megacenter.service.impl;

import com.megacenter.Model.Leyenda;
import com.megacenter.dao.ILeyendaDAO;
import com.megacenter.service.ILeyendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeyendaServiceImpl implements ILeyendaService {

    @Autowired
    private ILeyendaDAO dao;

    @Override
    public Leyenda registrar(Leyenda leyenda) {
        return dao.save(leyenda);
    }

    @Override
    public void modificar(Leyenda leyenda) {
        dao.save(leyenda);
    }

    @Override
    public void eliminar(int idLeyenda) {
        dao.deleteById(idLeyenda);
    }

    @Override
    public Leyenda listarId(int idLeyenda) {
        return dao.findById(idLeyenda).get();
    }

    @Override
    public List<Leyenda> listar() {
        return dao.findAll();
    }
}
