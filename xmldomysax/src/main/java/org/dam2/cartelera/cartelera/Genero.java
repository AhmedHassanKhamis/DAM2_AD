package dam2.org.xmldomsax.cartelera;

import java.util.Arrays;

public enum Genero {
	COMEDIA {public String toString() {return "Comedia";}}, 
	TERROR {public String toString() {return "Terror";}}, 
	AVENTURA {public String toString() {return "Aventura";}}, 
	DOCUMENTAL {public String toString() {return "Documental";}};
	
	public static Genero crearGenero (String valor)
	{
		return Arrays.stream(Genero.values()).
				filter(g -> g.toString().equalsIgnoreCase(valor)).
				findFirst().
				orElse(AVENTURA);
	}
}
