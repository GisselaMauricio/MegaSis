package com.megacenter.service;

import java.util.List;

import com.megacenter.Model.Egreso;
import com.megacenter.representation.FiltroEgresoDTO;

public interface IEgresoService {

    Egreso registrar(Egreso egreso);

    void modificar(Egreso egreso);

    void eliminar(int idEgreso);

    Egreso listarId(int idEgreso);

    List<Egreso> listar();
        
//    List<Egreso> buscarfecha(FiltroEgresoDTO filtro);
    
}
