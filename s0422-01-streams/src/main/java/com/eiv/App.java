package com.eiv;

import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {

		List<Persona> personas = Persona.personas();
		personas.forEach(persona -> System.out.println(persona));
		List<String> apellidos = personas.stream()
				.map(persona -> persona.getApellido())
				.sorted((a1, a2) -> a1.compareTo(a2))
				.collect(Collectors.toList());
		
		apellidos.forEach(apellido -> System.out.println(apellido));
	}

}
