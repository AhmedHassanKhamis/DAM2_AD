package org.dam2.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class RepasoInterfaces {

	public static void main(String[] args) {

		
		
//		queremos escribir hola mundo aprovechando una interfaz consumidor
		
		
//	CONSUMIR COSAS -> DEL ESTILO DE IMPRIMIR
//		tipoInterfaz <IDIOMA EN EL QUE ESCUCHA> NOMBREINTERFAZ = LO QUE HACE
		Consumer<String> CONSUMIDOR = (VALOR) -> System.out.println(VALOR);
		
		
		
//	TRANSFORMAR COSAS -> DEL ESTILO CAMBIAR A UPPERCASE ALGO O CONCATENAR CON MIS HUEVOS
//		tipoInterfaz <IDIOMA EN EL QUE ESUCHA, IDIOMA EN EL QUE HABLA> NOMBREINTERFAZ = LO QUE HACE
		Function<String, String> MIFUNCION = VALOR -> VALOR + "MIS HUEVOS MORENOS";
		
		
//	VER SI CUMPLE UNA CONDICION (CONDICIONAL)
//		tipoInterfaz <IDIOMA EN EL QUE ESCUCHA> NOMBREINTERFAZ = LO QUE HACE 
		Predicate<Float> MIPREDICADO = VALOR -> VALOR > 5f;
		
		
//		String texto1 = "hola";
//		String texto2 = "mundo";
//		List<String> listaTexto2 = new  ArrayList<String>();
//		listaTexto2.add(texto1);
//		listaTexto2.add(texto2);
			
				
		String [] arrayTexto = {"hola","mundo","miguel","mario","hamster","mi padre", "Osama bin laden", "11 de septiembre"};
		List<String> listaTexto  = Arrays.asList(arrayTexto);

		
		
		Float [] arrayFloats = {10f,3f,};
		List<Float> listaFloats = Arrays.asList(arrayFloats);
		
//		map -> editar las cosas
//		forEach -> consumir las cosas
//		filter -> para quitar las cosas que no cumplan las condiciones que tu pongas
//		reduce -> para agrupar cosas mientras haces acciones sobre dichas cosas
		
//		listaTexto.stream().forEach(CONSUMIDOR);
		
		
		listaTexto.stream().map(MIFUNCION).forEach(CONSUMIDOR);
		
							
//		listaFloats.stream().filter(numerito -> numerito > 5).forEach(numerito -> System.out.println(numerito));
		listaTexto.stream().map(texto -> texto + "algo").forEach(texto -> System.out.println(texto));
		
		
		
		
	}

}
