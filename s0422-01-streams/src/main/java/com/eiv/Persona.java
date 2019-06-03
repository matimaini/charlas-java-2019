package com.eiv;

import java.util.Arrays;
import java.util.List;

public class Persona {

	private Long id;
	private String nombre;
	private String apellido;

	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(Long id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	public static List<Persona> personas() {
		return Arrays.asList(new Persona(1L, "nombre", "asdasd"), new Persona(2L, "Matias", "Maini"));
	}
}
