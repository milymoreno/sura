package com.prueba.financiera.validation;

import java.util.Optional;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.prueba.financiera.domain.model.entity.Cliente;
import com.prueba.financiera.infrastructure.repository.ClienteRepository;

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

