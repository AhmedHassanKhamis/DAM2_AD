package org.dam2.ejercicioJson3;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {

	public static void main(String[] args) {

		ListaWrapper lista = leerJson();

		mostrarJson(lista);
		
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
