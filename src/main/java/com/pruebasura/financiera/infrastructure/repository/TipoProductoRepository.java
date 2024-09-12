package com.pruebasura.financiera.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebasura.financiera.domain.model.entity.TipoProducto;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
}
