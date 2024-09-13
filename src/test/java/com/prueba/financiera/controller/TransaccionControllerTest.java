package com.prueba.financiera.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prueba.financiera.application.service.InterfaceTransaccionService;
import com.prueba.financiera.domain.model.entity.Transaccion;
import com.prueba.financiera.infrastructure.controller.TransaccionController;

public class TransaccionControllerTest {

    @Mock
    private InterfaceTransaccionService transaccionService;

    @InjectMocks
    private TransaccionController transaccionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCrearTransaccion() {
        // Mock data
        Transaccion transaccion = new Transaccion();
        transaccion.setId(1L);
        transaccion.setMonto(BigDecimal.valueOf(100.0));
        transaccion.setFecha(LocalDateTime.now());

        when(transaccionService.crearTransaccion(any(Transaccion.class))).thenReturn(transaccion);

        // Test
        ResponseEntity<Transaccion> responseEntity = transaccionController.crearTransaccion(transaccion);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(transaccion, responseEntity.getBody());
    }

    @Test
    public void testObtenerTodasLasTransacciones() {
        // Mock data
        List<Transaccion> transacciones = new ArrayList<>();
        transacciones.add(new Transaccion());
        transacciones.add(new Transaccion());

        when(transaccionService.obtenerTodasLasTransacciones()).thenReturn(transacciones);

        // Test
        ResponseEntity<List<Transaccion>> responseEntity = transaccionController.obtenerTodasLasTransacciones();

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(transacciones, responseEntity.getBody());
    }
}
