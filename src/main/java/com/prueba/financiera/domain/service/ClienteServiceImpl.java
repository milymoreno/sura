package com.prueba.financiera.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.financiera.application.service.InterfaceClienteService;
import com.prueba.financiera.domain.model.entity.Cliente;
import com.prueba.financiera.infrastructure.repository.ClienteRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements InterfaceClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void validarCliente(Cliente cliente) {
        if (!cliente.esMayorDeEdad()) {
            throw new IllegalArgumentException("El cliente debe ser mayor de edad.");
        }
        Optional<Cliente> clienteExistente = clienteRepository.findByTipoIdentificacionAndNumeroIdentificacion(cliente.getTipoIdentificacion(), cliente.getNumeroIdentificacion());
        if (clienteExistente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un cliente con el mismo tipo y número de identificación.");
        }
       
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        validarCliente(cliente);
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente clienteDetalles) {
        
        Cliente cliente = obtenerClientePorId(id);
        cliente.setNombres(clienteDetalles.getNombres());
        cliente.setApellidos(clienteDetalles.getApellidos());
        cliente.setEmail(clienteDetalles.getEmail());
        return clienteRepository.save(cliente);
    }

    

    @Override
    @Transactional
    public void eliminarCliente(Long id) {        
        Cliente cliente = obtenerClientePorId(id);
        // Verificar si el cliente tiene productos vinculados
        if (!cliente.getProductos().isEmpty()) {
            throw new IllegalStateException("No se puede eliminar el cliente porque tiene productos vinculados.");
        }
        clienteRepository.delete(cliente);
    }


    @Override
    public Cliente obtenerClientePorId(Long id) {
        // Implementación del método obtenerClientePorId
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        return optionalCliente.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado."));
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        // Implementación del método obtenerTodosLosClientes
        return clienteRepository.findAll();
    }
}
