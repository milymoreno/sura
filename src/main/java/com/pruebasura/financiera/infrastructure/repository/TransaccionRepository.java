package com.pruebasura.financiera.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebasura.financiera.domain.model.entity.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}

