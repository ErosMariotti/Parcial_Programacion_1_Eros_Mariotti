# Parcial_Programacion_1_Eros_Mariotti

# Parcial1Programacion

# DNA Mutant Detector

Consiste en una aplicación de Spring Boot creada para detectar si una secuencia de DNA pertenece a un mutante o no. La lógica de detección de mutante se basa en identificar secuencias repetitivas de bases nitrogenadas (A, T, C, G) en filas, columnas y diagonales de una matriz cuadrada de ADN. Si hay cuatro lestras iguales colocadas de manera consecutiva, entonces ese DNA es mutante.

# Estructura del Proyecto

src/main/java/com/parcialProgramacion/parcial1/ParcialProgramaciomApplication.java: Clase principal que inicia la aplicación Spring Boot.
src/main/java/com/parcialProgramacion/parcial1/service/MutantService.java: Clase que contiene la lógica para determinar si una secuencia de ADN es mutante.
src/main/java/com/parcialProgramacion/parcial1/service/StatsService.java: Clase que proporciona estadísticas sobre las secuencias de ADN analizadas.
src/main/java/com/parcialProgramacion/parcial1/service/ValidationsService.java: Clase encargada de validar la entrada de datos del ADN.
src/main/java/com/parcialProgramacion/parcial1/repositories/MutantRepository.java: Interfaz que gestiona la interacción con la base de datos H2 para almacenar secuencias analizadas.
src/test/java/com/parcialProgramacion/parcial1/ParcialProgramaciomApplicationTests.java: Clase que contiene los tests unitarios para validar la funcionalidad del detector de mutantes.

# Lógica de Detección
La clase MutantService implementa la lógica para verificar si una secuencia de ADN es mutante. Busca secuencias de cuatro bases nitrogenadas idénticas en filas, columnas y diagonales de la matriz. Si se encuentran más de una secuencia, el ADN se considera mutante.

# Validaciones
Antes de realizar la detección, se llevan a cabo varias validaciones en la entrada:

El array de ADN no puede ser null.
El array de ADN no puede estar vacío.
Cada fila del array de ADN no puede ser null.
El array de ADN debe ser cuadrado (NxN).
Cada fila del array de ADN solo puede contener los caracteres 'A', 'T', 'C', 'G'.

# Tests Unitarios
Los tests unitarios se encuentran en la clase ParcialProgramaciomApplication y ParcialProgramaciomApplicationTest y cubren los siguientes casos:

# Manejo de Errores
Array vacío: Verifica que se lance una excepción cuando el array de ADN está vacío.
Array NxM: Verifica que se lance una excepción cuando el array de ADN no es cuadrado.
Array con números: Verifica que se lance una excepción cuando el array de ADN contiene caracteres inválidos.
Array nulo: Verifica que se lance una excepción cuando el array de ADN es null.
Array con filas nulas: Verifica que se lance una excepción cuando alguna fila del array de ADN es null.
Array con caracteres no válidos: Verifica que se lance una excepción cuando el array de ADN contiene caracteres diferentes a 'A', 'T', 'C', 'G'.

# Casos de Prueba
Caso 1: Mutante: Verifica que una secuencia de ADN con múltiples secuencias repetitivas sea detectada como mutante.
Caso 2: No Mutante: Verifica otro caso de secuencia de ADN mutante.
Caso 3: Mutante: Verifica caso de secuencia de ADN mutante.
Caso 4: No Mutante: Verifica caso de secuencia de ADN mutante.
Caso 5: No Mutante: Verifica caso de secuencia de ADN mutante.
Caso 6: Mutante: Verifica caso de secuencia de ADN mutante.
Caso 7: Mutante: Verifica caso de secuencia de ADN mutante.

# Ejecución de Tests
Para ejecutar los tests unitarios, utiliza el siguiente comando de Gradle:

./gradlew test
