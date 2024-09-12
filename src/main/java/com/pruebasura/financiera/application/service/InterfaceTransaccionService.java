package com.pruebasura.financiera.application.service;

import java.util.List;

import com.pruebasura.financiera.domain.model.entity.Transaccion;

public interface InterfaceTransaccionService {

    Transaccion crearTransaccion(Transaccion transaccion);

    List<Transaccion> obtenerTodasLasTransacciones();
}
