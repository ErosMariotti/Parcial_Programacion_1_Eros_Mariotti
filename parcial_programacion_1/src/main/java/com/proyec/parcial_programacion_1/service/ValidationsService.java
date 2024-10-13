package com.proyec.parcial_programacion_1.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationsService {

    // Valida que el array no sea nulo ni esté vacío
    static void validarArrayNoVacio(String[] array) throws Exception {
        if (array == null) {
            throw new Exception("El array no puede ser null.");
        }
        if (array.length == 0) {
            throw new Exception("El array está vacío.");
        }
    }

    // Procesa el array y lanza una excepción si está vacío
    static void procesarArray(String[] array) throws Exception {
        if (array.length == 0) {
            throw new Exception("El array está vacío.");
        }
    }

    // Valida que el array sea cuadrado (todas las filas deben tener la misma longitud que el número de filas)
    static void validarArray(String[] array) throws Exception {
        int n = array.length;
        if (n == 0) {
            throw new Exception("El array está vacío.");
        }
        for (String row : array) {
            if (row.length() != n) {
                throw new Exception("El array no es cuadrado.");
            }
        }
    }

    // Valida que el contenido del array solo contenga caracteres válidos ('A', 'T', 'C', 'G')
    static void validarContenido(String[] array) throws Exception {
        for (int i = 0; i < array.length; i++) {
            String row = array[i];

            // Verifica si una fila es null
            if (row == null) {
                throw new Exception("Una fila del array es null.");
            }

            // Solo aquí podemos empezar a procesar la fila si no es null
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                if (c != 'A' && c != 'T' && c != 'C' && c != 'G') {
                    throw new Exception("Caracter inválido en el array de ADN.");
                }
            }
        }
    }


}