package org.dam2.ejercicioJson2;

import java.util.Arrays;

public enum TipoFormacion {
	METROPOLITANA{public String toString() { return "Zona Metropolitana";}};
	
	public static TipoFormacion crearTipoFormacion(String value) {
		return Arrays.stream(TipoFormacion.values()).filter(t -> t.toString().equalsIgnoreCase(value)).findFirst().orElse(METROPOLITANA);
	}

}
