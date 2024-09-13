package com.prueba.financiera.infrastructure.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.financiera.domain.model.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findByNumeroCuenta(String numeroCuenta);
}

