package com.proyec.parcial_programacion_1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Dna implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id; // clave primaria Long

    private String dna; // Campo que almacena la secuencia de ADN
    private boolean isMutant; // Campo que indica si la secuencia de ADN es mutante o no
}