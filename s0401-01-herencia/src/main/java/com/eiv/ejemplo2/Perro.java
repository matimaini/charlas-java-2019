package com.eiv.ejemplo2;

public class Perro extends Animal {

	@Override
	public String descripcion() {
		String animal = super.descripcion();
		return animal + " - clase perro";
	}

	@Override
	public String sonido() {
		return "guau guau";
	}
	
	public static String algo() {
		return "ALGO";
	}
}
