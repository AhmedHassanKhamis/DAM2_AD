package org.dam2.ejercicioPaisesJson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pais> paisesDylan = leerJson();
		escribirJson(paisesDylan);
		
		
		
	}
	
	
	public static List<Pais> leerJson(){
		List<Pais> paises = new ArrayList<Pais>();
		
		try {
			GsonBuilder creadorGson = new GsonBuilder();
			Gson gson = creadorGson.create();
			Type listaDeObjetos = TypeToken.getParameterized(List.class, Pais.class).getType();
			paises = gson.fromJson(new FileReader("paises.json"), listaDeObjetos);			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return paises;
		
	}
	
	
	public static void escribirJson(List<Pais> paises) {
		try {
			Writer writer = new FileWriter("paises.json");
			GsonBuilder creadorGson = new GsonBuilder();
			creadorGson.setPrettyPrinting();
			Gson gson = creadorGson.create();
			gson.toJson (paises,writer);
			gson.toJson (paises, System.out);
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

}
