package com.proyec.parcial_programacion_1.controllers;

import com.proyec.parcial_programacion_1.dto.DnaRequest;
import com.proyec.parcial_programacion_1.dto.DnaResponse;
import com.proyec.parcial_programacion_1.service.MutantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mutant")
public class DnaController {

    private final MutantService mutantService;

    // Constructor que inyecta el MutantService

    public DnaController(MutantService mutantService){
        this.mutantService = mutantService;
    }

    @PostMapping // Mapea las solicitudes POST a este metodo
    public ResponseEntity<DnaResponse> checkMutant(@Validated @RequestBody DnaRequest dnaRequest) throws Exception {

        // Llama al servicio MutantService para analizar si la secuencia de ADN es mutante
        boolean isMutant = mutantService.analyzeDna(dnaRequest.getDna());

        // Crea un objeto DnaResponse que contendrá el resultado del análisis
        DnaResponse dnaResponse = new DnaResponse(isMutant);

        // Si el ADN es mutante, devuelve una respuesta HTTP 200 (OK)
        if(isMutant){
            return ResponseEntity.ok(dnaResponse);
        } else {
            // Si no es mutante, devuelve una respuesta HTTP 403 (FORBIDDEN)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dnaResponse);
        }
    }
}