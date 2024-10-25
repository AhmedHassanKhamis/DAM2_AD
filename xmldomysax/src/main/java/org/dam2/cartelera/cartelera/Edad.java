package dam2.org.xmldomsax.cartelera;

import java.util.Arrays;

public enum Edad {
	TODOSLOSPUBLICOS  {public String toString() {return "tp";}}, 
	MAYORES18 {public String toString() {return "+18";}},
	MAYORES14 {public String toString() {return "+14";}};
	
	public static Edad crearEdad (String v)
	{
	
		return  Arrays.stream(Edad.values()).
			filter(e -> e.toString().equals(v)).
			findFirst().
			orElse(Edad.TODOSLOSPUBLICOS);
	}
}
