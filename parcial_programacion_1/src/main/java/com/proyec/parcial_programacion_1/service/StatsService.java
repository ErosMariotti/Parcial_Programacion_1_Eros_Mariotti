package com.proyec.parcial_programacion_1.service;

import com.proyec.parcial_programacion_1.dto.StatsResponse;
import com.proyec.parcial_programacion_1.repositories.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    private final MutantRepository mutantRepository;

    // Constructor con inyección de dependencias

    @Autowired
    public StatsService(MutantRepository mutantRepository){
        this.mutantRepository = mutantRepository;
    }

    // Metodo para obtener las estadísticas

    public StatsResponse getStats(){
        // Obtiene el número de secuencias mutantes
        long countMutantDna = mutantRepository.countByIsMutant(true);

        // Obtiene el número de secuencias humanas (no mutantes)
        long countHumanDna = mutantRepository.countByIsMutant(false);

        // Calcula el ratio de mutantes a humanos, protegiendo contra divisiones por 0
        double ratio = countHumanDna == 0 ? 0 : (double) countMutantDna / countHumanDna;

        // Retorna una nueva instancia de StatsResponse con los valores calculados
        return new StatsResponse(countMutantDna, countHumanDna, ratio);
    }
}