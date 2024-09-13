package com.prueba.financiera.domain.model.entity;


import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//import java.util.Set;

import org.hibernate.validator.constraints.Length;

import com.prueba.financiera.validation.UniqueCliente;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Entity
@Data
@UniqueCliente(message = "Ya existe un cliente registrado con este tipo y número de identificación")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El tipo de identificación es obligatorio")
    private String tipoIdentificacion;

    @NotBlank(message = "El número de identificación es obligatorio")
    private String numeroIdentificacion;

    @NotBlank(message = "Los nombres son obligatorios")
    @Length(min = 2, message = "Los nombres deben tener al menos 2 caracteres")
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Length(min = 2, message = "Los apellidos deben tener al menos 2 caracteres")
    private String apellidos;

    @Email(message = "El correo electrónico debe tener un formato válido")
    @NotBlank(message = "El correo electrónico es obligatorio")
    private String email;

    private LocalDateTime fechaNacimiento;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos;
    
    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaModificacion = LocalDateTime.now();
    }

    public boolean esMayorDeEdad() {
        return Period.between(fechaNacimiento.toLocalDate(), LocalDateTime.now().toLocalDate()).getYears() >= 18;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}

