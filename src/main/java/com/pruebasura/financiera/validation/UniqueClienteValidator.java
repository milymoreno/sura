package com.pruebasura.financiera.validation;

import com.pruebasura.financiera.domain.model.entity.Cliente;
import com.pruebasura.financiera.infrastructure.repository.ClienteRepository;

import java.util.Optional;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueClienteValidator implements ConstraintValidator<UniqueCliente, Cliente> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(UniqueCliente constraintAnnotation) {
    }

    @Override
    public boolean isValid(Cliente cliente, ConstraintValidatorContext context) {
        // Implementa la lógica para validar la unicidad de tipo y número de identificación
        if (cliente == null) {
            return true; 
        }
        // Verifica si ya existe un cliente con el mismo tipo y número de identificación
        Optional<Cliente> existingCliente = clienteRepository.findByTipoIdentificacionAndNumeroIdentificacion(
                cliente.getTipoIdentificacion(), cliente.getNumeroIdentificacion());

        if (existingCliente.isEmpty()) {
            return true;
        }    
        return existingCliente.get().getId().equals(cliente.getId());
    }

}

