# Parcial1Programacion Eros Mariotti

# DNA Mutant Detector

Consiste en una aplicación de Spring Boot creada para detectar si una secuencia de DNA pertenece a un mutante o no.

La clase MutantService implementa la lógica para verificar si una secuencia de ADN es mutante. Busca secuencias de cuatro bases nitrogenadas (A, T, C, G) idénticas en filas, columnas y diagonales de la matriz. Si se encuentran más de una secuencia, el ADN se considera mutante.

# Estructura del Proyecto

- src/main/java/com/proyec/parcial_programacion_1/ParcialProgramacion1Application.java: Clase principal que inicia la aplicación Spring Boot.
  
- src/main/java/com/proyec/parcial_programacion_1/service/MutantService.java: Clase que contiene la lógica para determinar si una secuencia de ADN es mutante o no.
  
- src/main/java/com/proyec/parcial_programacion_1/service/StatsService.java: Clase que proporciona estadísticas sobre las secuencias de ADN analizadas.
  
- src/main/java/com/proyec/parcial_programacion_1/service/ValidationsService.java: Clase encargada de validar la entrada de datos del ADN.
  
- src/main/java/com/proyec/parcial_programacion_1/repositories/MutantRepository.java: Interfaz que gestiona la interacción con la base de datos H2 para almacenar secuencias analizadas.
  
- src/main/java/com/proyec/parcial_programacion_1/config/SwaggerConfig: Clase que implementa Swagger.
  
- src/main/java/com/proyec/parcial_programacion_1/ParcialProgramacion1ApplicationTests.java: Clase que contiene los 16 tests unitarios para validar la funcionalidad del detector de mutantes.

# Tests Unitarios
Los tests unitarios se encuentran en la clase ParcialProgramacion1ApplicationTests.java y cubren los siguientes casos:

# Manejo de Errores
Antes de realizar la detección, se llevan a cabo varias validaciones en la entrada:

- Array vacío: Verifica que se lance una excepción cuando el array de ADN está vacío.
- Array NxM: Verifica que se lance una excepción cuando el array de ADN no es cuadrado.
- Array con números: Verifica que se lance una excepción cuando el array de ADN contiene caracteres inválidos.
- Array nulo: Verifica que se lance una excepción cuando el array de ADN es null.
- Array con filas nulas: Verifica que se lance una excepción cuando alguna fila del array de ADN es null.
- Array con caracteres no válidos: Verifica que se lance una excepción cuando el array de ADN contiene caracteres diferentes a 'A', 'T', 'C', 'G'.

# Casos de Prueba
- Caso 1: Mutante: Verifica que una secuencia de ADN con múltiples secuencias repetitivas sea detectada como mutante.
- Caso 2: No Mutante: Verifica otro caso de secuencia de ADN mutante.
- Caso 3: Mutante: Verifica caso de secuencia de ADN mutante.
- Caso 4: Mutante: Verifica caso de secuencia de ADN mutante.
- Caso 5: No Mutante: Verifica caso de secuencia de ADN mutante.
- Caso 6: Mutante: Verifica caso de secuencia de ADN mutante.
- Caso 7: Mutante: Verifica caso de secuencia de ADN mutante.

# Ejecución de Tests
Para ejecutar los tests unitarios, utiliza el siguiente comando de Gradle:

./gradlew test

# Swagger

Para ver el proyecto en swagger, podés acceder desde el siguiente link: https://parcial-programacion-1-eros-mariotti.onrender.com/swagger-ui/index.html#/
