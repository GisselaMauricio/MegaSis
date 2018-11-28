package com.megacenter.service;

import com.megacenter.Model.Venta;

public interface IVentaService extends ICRUD<Venta> {
    Venta getUltimoNumeroComprobante(int Id);
}
