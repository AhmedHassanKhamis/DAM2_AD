package org.dam2.xmljabx.cartelera;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "cartelera")
@XmlType(propOrder = {"peliculas"})
@XmlAccessorType(XmlAccessType.FIELD) 
public class CarteleraWrapper {

	
	@XmlElement(name="pelicula") // elemento repetido del contenedor
	private List<Pelicula> peliculas;
	
	public boolean addPelicula(Pelicula pelicula) {
		if(peliculas == null)
			peliculas = new ArrayList<Pelicula>();
		return peliculas.add(pelicula);
	}
	
}
