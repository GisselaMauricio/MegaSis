package com.megacenter.service;

import com.megacenter.Model.Leyenda;

import java.util.List;

public interface ILeyendaService {

    Leyenda registrar(Leyenda leyenda);

    void modificar(Leyenda leyenda);

    void eliminar(int idLeyenda);

    Leyenda listarId(int idLeyenda);

    List<Leyenda> listar();
}
