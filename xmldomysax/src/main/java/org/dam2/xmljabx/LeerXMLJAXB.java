package org.dam2.xmljabx;
import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LeerXMLJAXB {
	
	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(CarteleraWrapper.class);
			Unmarshaller ums = context.createUnmarshaller();
			CarteleraWrapper peliculas =  (CarteleraWrapper) ums.unmarshal(new File("Peliculas1.xml"));
			for(Pelicula pelicula : peliculas.getPeliculas()) {
				System.out.println(pelicula.toString());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
