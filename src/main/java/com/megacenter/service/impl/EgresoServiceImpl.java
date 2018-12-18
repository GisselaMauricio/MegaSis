package com.megacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Egreso;
import com.megacenter.dao.IEgresoDAO;
import com.megacenter.service.IEgresoService;

@Service
public class EgresoServiceImpl implements IEgresoService {

    @Autowired
    private IEgresoDAO dao;

    @Override
    public Egreso registrar(Egreso egreso) {
        return dao.save(egreso);
    }

    @Override
    public void modificar(Egreso egreso) {
        dao.save(egreso);
    }

    @Override
    public void eliminar(int idEgreso) {
        dao.deleteById(idEgreso);
    }

    @Override
    public Egreso listarId(int idEgreso) {
        return dao.findById(idEgreso).get();
    }

    @Override
    public List<Egreso> listar() {
        return dao.findAll();
    }

//	@Override
//	public List<Egreso> buscarfecha(FiltroEgresoDTO filtro) {
//		LocalDateTime fechaSgte = filtro.getFechaConsulta().plusDays(1);
//		return dao.buscarPorFecha(filtro.getFechaConsulta(), fechaSgte);
//	}
}
