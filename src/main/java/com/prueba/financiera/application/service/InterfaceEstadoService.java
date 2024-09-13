package com.prueba.financiera.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.financiera.domain.model.entity.Estado;
import com.prueba.financiera.infrastructure.repository.EstadoRepository;

@Service
public class InterfaceEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado getEstadoActivo() {
        return estadoRepository.findByNombre("Activo")
                .orElseThrow(() -> new IllegalArgumentException("Estado 'Activo' no encontrado."));
    }
}
