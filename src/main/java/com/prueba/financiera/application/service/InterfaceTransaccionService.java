package com.prueba.financiera.application.service;

import java.util.List;

import com.prueba.financiera.domain.model.entity.Transaccion;

public interface InterfaceTransaccionService {

    Transaccion crearTransaccion(Transaccion transaccion);

    List<Transaccion> obtenerTodasLasTransacciones();
}
