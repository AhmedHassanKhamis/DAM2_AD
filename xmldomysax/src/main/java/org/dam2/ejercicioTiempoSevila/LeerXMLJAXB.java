package org.dam2.ejercicioTiempoSevila;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class LeerXMLJAXB {
	private final static Consumer<Object> ESCRIBIDOR = System.out::println;
	
	
	public static void main(String[] args) {
		try {
			Marshaller ms;
			JAXBContext context = JAXBContext.newInstance(CarteleraWrapper.class);
			Unmarshaller ums = context.createUnmarshaller();
			CarteleraWrapper peliculas =  (CarteleraWrapper) ums.unmarshal(new File("Peliculas1.xml"));
			for(Tiempo pelicula : peliculas.getPeliculas()) {
				System.out.println(pelicula.toString());
			}
			
			
			context = JAXBContext.newInstance(CarteleraWrapper.class);
			// Crear marshaller, objeto que se encarga de escribir el XML
			ms = context.createMarshaller();
						
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(peliculas, System.out);
			
			
			System.out.println("REPARTO:-----------------------------");
			peliculas.getPeliculas().stream().filter(p-> p.getFecha().isAfter(LocalDate.of(2003, 1, 1))).flatMap(p -> p.getReparto().stream()).forEach(ESCRIBIDOR);;
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
