package com.pruebasura.financiera.application.serviceI;

import java.util.List;

import com.pruebasura.financiera.domain.model.entity.Cliente;

public interface ClienteService {

    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(Long id, Cliente clienteDetalles);

    void eliminarCliente(Long id);

    Cliente obtenerClientePorId(Long id);

    List<Cliente> obtenerTodosLosClientes();
}
