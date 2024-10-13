package com.proyec.parcial_programacion_1.controllers;

import com.proyec.parcial_programacion_1.dto.StatsResponse;
import com.proyec.parcial_programacion_1.service.StatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {
    private final StatsService statsService;

    // Constructor que inyecta el StatsService

    public StatsController(StatsService statsService){
        this.statsService =  statsService;
    }

    @GetMapping
    public StatsResponse getStats(){
        // Llama al servicio StatsService para obtener las estadísticas y las devuelve como respuesta
        return statsService.getStats();
    }
}