package com.prueba.financiera.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.financiera.domain.model.entity.TipoTransaccion;

import java.util.Optional;

@Repository
public interface TipoTransaccionRepository extends JpaRepository<TipoTransaccion, Long> {
    // Método para buscar un TipoTransaccion por su nombre
    Optional<TipoTransaccion> findByNombre(String nombre);
}
