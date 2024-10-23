package org.dam2.ejercicioTiempoSevila;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import daw.com.Teclado;

public class EscribirXMLJAXB {


	public static void main(String[] args) {
			
			JAXBContext context;
			Marshaller ms;
			CarteleraWrapper peliculas = new CarteleraWrapper();
			
			do
			{
				// Leer Pelicula
				Tiempo pelicula = new Tiempo();
				Controlador<Tiempo> controlador = new ControladorPeliculaConsola();
				controlador.leerDatos(pelicula);
				peliculas.addPelicula(pelicula);
				
			}while (Teclado.leerString("Seguir agregando peliculas?(s/n)").equalsIgnoreCase("S"));
		
			
		// Escribir XML
		try {
			
			// Crear contexto
			context = JAXBContext.newInstance(CarteleraWrapper.class);
			// Crear marshaller, objeto que se encarga de escribir el XML
			ms = context.createMarshaller();
						
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(peliculas, System.out);
			ms.marshal(peliculas, new FileWriter("Peliculas1.xml"));
			
			
		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
