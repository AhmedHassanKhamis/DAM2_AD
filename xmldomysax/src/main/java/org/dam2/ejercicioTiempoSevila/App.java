package org.dam2.ejercicioTiempoSevila;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class App {

	public static void main(String[] args) {
		Tiempo tiempo = LeerXml();
		System.out.println(tiempo);
		Tiempo tiempoAMano = PedirDatos();
//		la humedad media de todos los datos registrados
		EscribirXml(tiempoAMano);
//		System.out.println(tiempo.getDatosRegistrados().getDatos_registrados().stream().mapToDouble(Dato::getHumedad).average().orElse(0));
		
	}

	
	
	
	public static void EscribirXml(Tiempo tiempo) {

		JAXBContext context;
		Marshaller ms;

//		Tiempo tiempo = new Tiempo();
//		Controlador<Tiempo> controlador = new ControladorTiempoConsola();
//		controlador.leerDatos(tiempo);

		// Escribir XML
		try {

			// Crear contexto
			context = JAXBContext.newInstance(Tiempo.class);
			// Crear marshaller, objeto que se encarga de escribir el XML
			ms = context.createMarshaller();

			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(tiempo, System.out);
			ms.marshal(tiempo, new FileWriter("Tiempo1.xml"));

		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	public static Tiempo LeerXml() {
		Tiempo tiempo = null;
		try {
			Marshaller ms;
			JAXBContext context = JAXBContext.newInstance(Tiempo.class);
			Unmarshaller ums = context.createUnmarshaller();
			tiempo = (Tiempo) ums.unmarshal(new File("sevilla.xml"));
			context = JAXBContext.newInstance(Tiempo.class);
						
			
			// Crear marshaller, objeto que se encarga de escribir el XML
			ms = context.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			System.out.println("pocho");

			
			
			ms.marshal(tiempo, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return tiempo;
	}
	
	
	public static Tiempo PedirDatos() {
		Tiempo tiempo = new Tiempo();
		Controlador<Tiempo> controlador = new ControladorTiempoConsola();
		controlador.leerDatos(tiempo);
		return tiempo;
	}

}
