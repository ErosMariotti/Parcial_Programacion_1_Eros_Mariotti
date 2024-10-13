package com.proyec.parcial_programacion_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DnaRequest {

    // Almacenamiento de la secuencia de ADN

    private String[] dna;
}