package com.proyec.parcial_programacion_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DnaResponse {

    // Es mutante o no?

    private boolean isMutant;

    // Metodo getter explícito para isMutant

    public boolean isMutant(){
        return isMutant;
    }
}