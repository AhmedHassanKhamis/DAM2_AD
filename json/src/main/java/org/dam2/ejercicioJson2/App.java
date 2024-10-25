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

import org.dam2.ejercicioJson1.Personas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class App {

	public static void main(String[] args) {

		List<PruebaDeNivel> pruebas;
		pruebas = LeerPruebasDeNivel();
		
		System.out.println(pruebas);
		
	}

	public static void escribirPruebasDeNivelXml(List<PruebaDeNivel> pruebas) {

		JAXBContext context;
		Marshaller ms;

//		Tiempo tiempo = new Tiempo();
//		Controlador<Tiempo> controlador = new ControladorTiempoConsola();
//		controlador.leerDatos(tiempo);

		// Escribir XML
		try {

			// Crear contexto
			context = JAXBContext.newInstance(PruebaDeNivel.class);
			// Crear marshaller, objeto que se encarga de escribir el XML
			ms = context.createMarshaller();

			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(pruebas, System.out);
			ms.marshal(pruebas, new FileWriter("pruebasdenivel.xml"));

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
			GsonBuilder creadorGson = new GsonBuilder().setPrettyPrinting();
			gson = creadorGson.create();
	        System.out.println(gson.toJson(pruebas));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
