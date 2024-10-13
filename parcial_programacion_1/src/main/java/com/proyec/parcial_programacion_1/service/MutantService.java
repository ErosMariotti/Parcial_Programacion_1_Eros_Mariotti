package com.proyec.parcial_programacion_1.service;

import com.proyec.parcial_programacion_1.entities.Dna;
import com.proyec.parcial_programacion_1.repositories.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MutantService {

    private final MutantRepository mutantRepository;

    private static final int SEQUENCE_LENGTH = 4; // Constante que define la longitud de la secuencia a buscar

    // Constructor para inyección de dependencias
    @Autowired
    public MutantService(MutantRepository mutantRepository) {
        this.mutantRepository = mutantRepository;
    }

    // Metodo principal que analiza si una secuencia de ADN es mutante o no
    public boolean analyzeDna(String[] dna) throws Exception {

        if (dna == null) {
            throw new Exception("El array no puede ser null.");
        }

        // Si el array no es null, realiza las validaciones
        ValidationsService.validarArrayNoVacio(dna);
        ValidationsService.validarContenido(dna);


        // Convertir el array de DNA en una secuencia string
        String dnaSequence = String.join(",", dna);

        //Verificación de existencia previa
        Optional<Dna> existingDna = mutantRepository.findByDna(dnaSequence);
        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }

        // Calcular si es mutante
        boolean isMutant = isMutant(dna);

        // Guardar el resultado en la base de datos
        Dna dnaEntity = Dna.builder()
                .dna(dnaSequence)
                .isMutant(isMutant)
                .build();

        // Guardar a través de la instancia de mutantRepository
        mutantRepository.save(dnaEntity);


        return isMutant(dna);
    }


    // Metodo que realiza las validaciones y verifica si es mutante
    public static boolean isMutant(String[] dna) throws Exception {

        // Valida si el array de ADN es correcto
        ValidationsService.procesarArray(dna);  // Valida si el array está vacío
        ValidationsService.validarArrayNoVacio(dna);  // Valida que el array no sea null o vacío
        ValidationsService.validarArray(dna);  // Valida que el array sea cuadrado
        ValidationsService.validarContenido(dna);  // Valida que el array contenga caracteres válidos

        int n = dna.length;
        int sequenceCount = 0;

        // Virificación de Filas
        sequenceCount += checkHorizontal(dna, n);
        if (sequenceCount > 1) return true;

        // Virificación de Columnas
        sequenceCount += checkVertical(dna, n);
        if (sequenceCount > 1) return true;

        // Virificación de Diagonales
        sequenceCount += checkDiagonals(dna, n);
        return sequenceCount > 1; // Retorna true si hay más de una secuencia
    }

    // Metodo para verificar secuencias horizontales

    private static int checkHorizontal(String[] dna, int n) {
        int countSequence = 0;

        // Recorre cada fila
        for (int i = 0; i < n; i++){
            int count = 1; // Contador de caracteres consecutivos
            for (int j = 1; j < n; j++){
                if (dna[i].charAt(j) == dna[i].charAt(j-1)){
                    count++;
                    if (count == SEQUENCE_LENGTH){
                        countSequence++;
                        if (countSequence > 1) return countSequence;
                    }
                } else {
                    count = 1; // Reinicia el contador si no son iguales
                }
            }
        }
        return countSequence;
    }

    // Metodo para verificar secuencias verticales

    private static int checkVertical(String[] dna, int n) {
        int countSequence = 0;

        // Recorre cada columna
        for (int j = 0; j < n; j++){
            int count = 1;
            for (int i = 1; i < n; i++){
                if (dna[i].charAt(j) == dna[i-1].charAt(j)){
                    count++;
                    if (count == SEQUENCE_LENGTH){
                        countSequence++;
                        if (countSequence > 1) return countSequence;
                    }
                } else {
                    count = 1;
                }
            }
        }
        return countSequence;
    }

    // Metodo para verificar secuencias diagonales (izquierda-derecha y derecha-izquierda)

    private static int checkDiagonals(String[] dna, int n) {
        int countSequence = 0;

        // Diagonales principales (de izquierda a derecha)
        for (int i = 0; i <= n - SEQUENCE_LENGTH; i++) {
            for (int j = 0; j <= n - SEQUENCE_LENGTH; j++) {
                if (checkDiagonal(dna, i, j, 1, 1, n)) {  // dx = 1, dy = 1
                    countSequence++;
                    if (countSequence > 1) return countSequence;
                }
            }
        }

        // Diagonales inversas (de derecha a izquierda)
        for (int i = 0; i <= n - SEQUENCE_LENGTH; i++) {
            for (int j = SEQUENCE_LENGTH - 1; j < n; j++) {
                if (checkDiagonal(dna, i, j, 1, -1, n)) {  // dx = 1, dy = -1
                    countSequence++;
                    if (countSequence > 1) return countSequence;
                }
            }
        }

        return countSequence;
    }

    // Metodo auxiliar para verificar diagonales

    private static boolean checkDiagonal(String[] dna, int x, int y, int dx, int dy, int n) {
        char first = dna[x].charAt(y);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            int newX = x + i * dx;
            int newY = y + i * dy;

            // Validamos que las nuevas posiciones están dentro de los límites del array
            if (newX >= n || newY >= n || newY < 0) {
                return false;
            }

            // Verificamos si los caracteres coinciden
            if (dna[newX].charAt(newY) != first) {
                return false;
            }
        }
        return true;
    }
}