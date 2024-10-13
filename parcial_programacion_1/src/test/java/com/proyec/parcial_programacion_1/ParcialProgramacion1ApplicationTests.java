package com.proyec.parcial_programacion_1;

import com.proyec.parcial_programacion_1.service.MutantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ParcialProgramacion1ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MutantService mutantService;


	@Test
	void testMutant() throws Exception {
		mockMvc.perform(post("/mutant")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"dna\":[\"AAAA\",\"CCCC\",\"TCAG\",\"GGTC\"]}"))
				.andExpect(status().isOk());
	}

	@Test
	void testNotMutant() throws Exception {
		mockMvc.perform(post("/mutant")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"dna\":[\"TGAC\",\"ATCC\",\"TAAG\",\"GGTC\"]}"))
				.andExpect(status().isForbidden());
	}

	// MANEJO DE ERRORES

	// Array vacio
	@Test
	void testArrayVacio() {
		String[] arrayVacio = {};
		Exception exception = assertThrows(Exception.class, () -> {
			mutantService.analyzeDna(arrayVacio);
		});
		assertEquals("El array está vacío.", exception.getMessage());
	}

	// Array NxM
	@Test
	void testArrayNxM() {
		String[] arrayNxM = {"ATGCA", "CAGTA", "TTATA", "AGAAG"};
		Exception exception = assertThrows(Exception.class, () -> {
			mutantService.analyzeDna(arrayNxM);
		});
		assertEquals("El array no es cuadrado.", exception.getMessage());
	}

	// Array de números
	@Test
	void testArrayConNumeros() {
		String[] arrayConNumeros = {"1234", "5678", "9123", "4567"};
		Exception exception = assertThrows(Exception.class, () -> {
			mutantService.analyzeDna(arrayConNumeros);
		});
		assertEquals("Caracter inválido en el array de ADN.", exception.getMessage());
	}

	// Recibir Null
	@Test
	void testArrayNull() {
		String[] arrayNull = null;
		Exception exception = assertThrows(Exception.class, () -> {
			mutantService.analyzeDna(arrayNull);
		});
		assertEquals("El array no puede ser null.", exception.getMessage());
	}

	// Array NxN Nulls
	@Test
	void testArrayConNulls() {
		String[] arrayConNulls = {null, null, null, null};
		Exception exception = assertThrows(Exception.class, () -> {
			mutantService.analyzeDna(arrayConNulls);
		});
		assertEquals("Una fila del array es null.", exception.getMessage());
	}

	// Array con caracteres invalidos
	@Test
	void testArrayConLetrasInvalidas() {
		String[] arrayConLetrasInvalidas = {"BHGC", "BHGC", "BHGC", "BHGC"};
		Exception exception = assertThrows(Exception.class, () -> {
			mutantService.analyzeDna(arrayConLetrasInvalidas);
		});
		assertEquals("Caracter inválido en el array de ADN.", exception.getMessage());
	}

	// MANEJO DE CASOS FACTIBLES

	// Caso 1: Mutante
	@Test
	void testMutante1() throws Exception {
		String[] mutante1 = {"AAAA", "CCCC", "TCAG", "GGTC"};
		assertTrue(mutantService.analyzeDna(mutante1));
	}

	// Caso 2: No mutante
	@Test
	void testNoMutante1() throws Exception {
		String[] noMutante1 = {"AAAT", "AACC", "AAAC", "CGGG"};
		assertFalse(mutantService.analyzeDna(noMutante1));
	}

	// Caso 3: Mutante
	@Test
	void testMutante2() throws Exception {
		String[] mutante2 = {"TGAC", "AGCC", "TGAC", "GGTC"};
		assertTrue(mutantService.analyzeDna(mutante2));
	}

	// Caso 4: No mutante
	@Test
	void testMutante3() throws Exception {
		String[] noMutante3 = {"AAAA", "AAAA", "AAAA", "AAAA"};
		assertTrue(mutantService.analyzeDna(noMutante3));
	}

	// Caso 5: No mutante
	@Test
	void testNoMutante3() throws Exception {
		String[] noMutante3 = {"TGAC", "ATCC", "TAAG", "GGTC"};
		assertFalse(mutantService.analyzeDna(noMutante3));
	}

	// Caso 6: Mutante
	@Test
	void testMutante4() throws Exception {
		String[] mutante4 = {
				"TCGGGTGAT", "TGATCCTTT", "TACGAGTGA",
				"AAATGTACG", "ACGAGTGCT", "AGACACATG",
				"GAATTCCAA", "ACTACGACC", "TGAGTATCC"
		};
		assertTrue(mutantService.analyzeDna(mutante4));
	}

	// Caso 7: Mutante
	@Test
	void testMutante5() throws Exception {
		String[] mutante5 = {
				"TTTTTTTTT", "TTTTTTTTT", "TTTTTTTTT",
				"TTTTTTTTT", "CCGACCGAT", "GGCACGCCA",
				"AGGACACTA", "CAAAGGCGT", "GCAGTCCCC"
		};
		assertTrue(mutantService.analyzeDna(mutante5));
	}

}
