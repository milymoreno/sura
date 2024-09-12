package com.pruebasura.financiera.application.serviceI;

import java.util.List;

import com.pruebasura.financiera.domain.model.entity.Transaccion;

public interface TransaccionService {

    Transaccion crearTransaccion(Transaccion transaccion);

    List<Transaccion> obtenerTodasLasTransacciones();
}
