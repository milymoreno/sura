package com.pruebasura.financiera.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebasura.financiera.domain.model.entity.Estado;
import com.pruebasura.financiera.infrastructure.repository.EstadoRepository;

@Service
public class InterfaceEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado getEstadoActivo() {
        return estadoRepository.findByNombre("Activo")
                .orElseThrow(() -> new IllegalArgumentException("Estado 'Activo' no encontrado."));
    }
}
