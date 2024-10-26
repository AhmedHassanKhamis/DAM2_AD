package org.dam2.ejercicioJson2;

import java.util.Arrays;

public enum Categoria {
	METROPOLITANA{public String toString() { return "Zona Metropolitana";}};
	
	public static Categoria crearCategoria(String value) {
		return Arrays.stream(Categoria.values()).filter(c -> c.toString().equalsIgnoreCase(value)).findFirst().orElse(METROPOLITANA);
	}

	
	
}
