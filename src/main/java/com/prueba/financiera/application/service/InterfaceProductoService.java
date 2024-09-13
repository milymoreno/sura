package com.prueba.financiera.application.service;

import java.util.List;

import com.prueba.financiera.domain.model.entity.Producto;

public interface InterfaceProductoService {

    Producto crearProducto(Producto producto);

    Producto actualizarProducto(Long id, Producto productoDetalles);

    void eliminarProducto(Long id);

    Producto obtenerProductoPorId(Long id);

    List<Producto> obtenerTodosLosProductos();
    
    //para consultar el estado de los productos o cuentas
    String consultarEstadoProducto(Long idProducto);

    Producto activarProducto(Long id);
    Producto inactivarProducto(Long id);
    void cancelarProducto(Long id);
}
