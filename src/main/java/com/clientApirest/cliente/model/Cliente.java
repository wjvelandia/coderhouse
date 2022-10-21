package com.clientApirest.cliente.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@Table (name= "cliente")
public class Cliente {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private LocalDate fecha_nacimiento;
    @Column
    private int edad;
    }
