package org.dam2.ejercicioRefuerzo;

import java.util.ArrayList;
import java.util.List;

public enum Tipos {
	Comestible,
	Limpieza,
	Belleza;
	
	public static List<Tipos> tipos(){
		List<Tipos> tipos = new ArrayList<>();
		tipos.add(Belleza);
		tipos.add(Comestible);
		tipos.add(Limpieza);
		return tipos;
	}
	
}
