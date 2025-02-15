package org.dam2.ejercicioJson1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {

	public static void main(String[] args) {
		Personas personas = LeerPersonas();
		System.out.println(personas);

		escribirPersonasXml(personas);
		
		mostrarPersonasJson(personas);

	}

	public static void escribirPersonasXml(Personas personas) {

		JAXBContext context;
		Marshaller ms;

//		Tiempo tiempo = new Tiempo();
//		Controlador<Tiempo> controlador = new ControladorTiempoConsola();
//		controlador.leerDatos(tiempo);

		// Escribir XML
		try {

			// Crear contexto
			context = JAXBContext.newInstance(Personas.class);
			// Crear marshaller, objeto que se encarga de escribir el XML
			ms = context.createMarshaller();

			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(personas, System.out);
			ms.marshal(personas, new FileWriter("personas.xml"));

		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Personas LeerPersonas() {
		Personas personas = null;
		try {
			Gson gson = new Gson();
			Reader reader = new FileReader(new File("personas.json"));
			personas = gson.fromJson(reader, Personas.class);

			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return personas;
	}

	public static void mostrarPersonasJson(Personas personas) {
		try {
			Gson gson;
			GsonBuilder creadorGson = new GsonBuilder().setPrettyPrinting();
			gson = creadorGson.create();
	        System.out.println(gson.toJson(personas));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
