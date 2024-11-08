package org.dam2.ejercicioMoviesJsonXml;

import java.util.List;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class GenreAdapterXML extends XmlAdapter<String, Genre>{

	@Override
	public Genre unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		
		List<String> generos = List.of(v.split(" "));
		
		Genre genero = new Genre(generos);
		
		
		return genero;
	}

	@Override
	public String marshal(Genre v) throws Exception {
		// TODO Auto-generated method stub
		
		String generos = v.getGenres().stream().reduce( (genero1,genero2) -> genero1 + " " + genero2).orElse("ninguno").toString();
		
		
		return generos;
	}

}
