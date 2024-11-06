package org.dam2.ejercicioJson2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import daw.com.Teclado;

public class App {

	public static void main(String[] args) {

		List<PruebaDeNivel> pruebas;
		pruebas = LeerPruebasDeNivel();
		pruebas.stream().forEach(System.out::println);

//		mostrarPruebasDeNivel(pruebas);		
//		escribirPruebasDeNivelXml(pruebas);
		
		System.out.println("\n\n");
//		¿Cuántas pruebas de idiomas están descritas en el documento?
//		System.out.println("pruebas de nivel -> "+pruebas.stream().count());
		
		
//		Muestra el título de las pruebas de nivel que van a durar más de dos horas.
//		System.out.println("\n\n");
//		pruebas.stream().filter(p -> p.getHoras() > 2).map(PruebaDeNivel::getTitulo).forEach(System.out::println);
		
//		De las pruebas de tipo "No Presencial" muestra la URL de información.
//		System.out.println("\n\n");
//		pruebas.stream().filter(p -> p.getTipoFormacion().toString().equalsIgnoreCase("No Presencial") || p.getTipoFormacion().toString().equalsIgnoreCase("NoPresencial")).map(PruebaDeNivel::getUrl).forEach(System.out::println);
		
		
		
//		Pide por teclado el código de la prueba "ID" y muestra su título y profesores.
//		String id = Teclado.leerString("Introduce el id a mostrar titulo y profesores:");
//		pruebas.stream().filter(p -> p.getId2().equalsIgnoreCase(id)).map(p -> p.getTitulo() +"-------------------------" + p.getProfesorado()).forEach(System.out::println);
		
		
		
		
//		Para cada uno de las pruebas, muestra su título y sus profesores.
		pruebas.stream().map(p -> p.getTitulo() +"-------------------------" + p.getProfesorado()).forEach(System.out::println);
		
		
	}

	public static void escribirPruebasDeNivelXml(List<PruebaDeNivel> pruebas) {

		
		PruebasDeNivelWrapper lista = new PruebasDeNivelWrapper(pruebas);
		// Escribir XML
		try {

			// Crear contexto
			JAXBContext context = JAXBContext.newInstance(PruebasDeNivelWrapper.class);
			// Crear marshaller, objeto que se encarga de escribir el XML
			Marshaller ms = context.createMarshaller();

			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(lista, System.out);
			ms.marshal(lista, new FileWriter("pruebasdenivel.xml"));

		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static List<PruebaDeNivel> LeerPruebasDeNivel() {
		List<PruebaDeNivel> pruebas = null;
		try {
			Gson gson = new Gson();
			Reader reader = new FileReader(new File("pruebasdenivel.json"));
			TypeToken<List<PruebaDeNivel>> listaPruebas = new TypeToken<List<PruebaDeNivel>>() {};
			pruebas = gson.fromJson(reader, listaPruebas);

			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return pruebas;
	}

	public static void mostrarPruebasDeNivel(List<PruebaDeNivel> pruebas) {
		try {
			Gson gson;
			GsonBuilder creadorGson = new GsonBuilder().serializeNulls().setPrettyPrinting();
			gson = creadorGson.create();
	        System.out.println(gson.toJson(pruebas));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
