package org.dam2.xmljabx;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LeerXMLJAXB {
	private final static Consumer<Object> ESCRIBIDOR = System.out::println;
	
	
	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(CarteleraWrapper.class);
			Unmarshaller ums = context.createUnmarshaller();
			CarteleraWrapper peliculas =  (CarteleraWrapper) ums.unmarshal(new File("Peliculas1.xml"));
			for(Pelicula pelicula : peliculas.getPeliculas()) {
				System.out.println(pelicula.toString());
			}
			
			
			
			System.out.println("REPARTO:-----------------------------");
			peliculas.getPeliculas().stream().filter(p-> p.getFecha().isAfter(LocalDate.of(2003, 1, 1))).flatMap(p -> p.getReparto().stream()).forEach(ESCRIBIDOR);;
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
