package org.dam2.ejercicioJson3;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daw.com.Teclado;

public class App {

	public static void main(String[] args) {

		ListaWrapper lista = leerJson();

//		mostrarJson(lista);
		
//		Lista todas las provincias.
		
//		lista.getLista().getProvincia().stream().map(p-> p.getNombre().getNombre()).forEach(System.out::println);
		
//		Lista todos los municipios.
		
//		lista.getLista().getProvincia().stream().flatMap(p-> p.getLocalidades().getLocalidad().stream()).map(localidad -> localidad.getNombre()).forEach(System.out::println);;
		
//		Lista de provincias y el total de municipios que tiene cada una.
		
//		lista.getLista().getProvincia().stream().map(p -> p.getNombre().getNombre()+ "->" + p.getLocalidades().getLocalidad().size()).forEach(System.out::println);;
		
//		Leer por teclado el nombre de una provincia y mostrar sus municipios.
//		String provincia = Teclado.leerString("introduce la provincia a mostrar sus municipios:");
//		lista.getLista().getProvincia().stream().filter(p -> p.getNombre().getNombre().equalsIgnoreCase(provincia)).flatMap(p -> p.getLocalidades().getLocalidad().stream()).forEach(System.out::println);
		
		
//		Leer por teclado el nombre de un municipio y mostrar la provincia donde se encuentra.
//		String municipio = Teclado.leerString("introduce municipio a mostrar su provicia:");
//		
//		lista.getLista().getProvincia().stream().filter(p -> p.getLocalidades().getLocalidad().stream().anyMatch(l -> l.getNombre().equalsIgnoreCase(municipio))).map(Provincia::getNombre).forEach(System.out::println);
		
//		En una lista tenemos distintos identificadores de provincias, 
//		mostrar el nombre de las provincias y todos los municipios correspondientes a los identificadores que se encuentran en la lista.
		
		String [] ids = {"0","30","51","28"};
		List<String> listaIds = Arrays.asList(ids);
		
		lista.getLista().getProvincia().stream().filter(p -> listaIds.contains(p.getId())).forEach(System.out::println);
		
	}

	public static ListaWrapper leerJson() {
		ListaWrapper lista = new ListaWrapper();
		try {
			Gson gson = new Gson();
			Reader reader = new FileReader(new File("provincias.json"));
			lista = gson.fromJson(reader, ListaWrapper.class);

			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return lista;
	}
	
	
	

	public static void mostrarJson(ListaWrapper lista) {
		try {
			Gson gson;
			GsonBuilder creadorGson = new GsonBuilder().setPrettyPrinting();
			gson = creadorGson.create();
			System.out.println(gson.toJson(lista));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
