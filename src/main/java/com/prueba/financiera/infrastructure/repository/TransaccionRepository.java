package com.prueba.financiera.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.financiera.domain.model.entity.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}

