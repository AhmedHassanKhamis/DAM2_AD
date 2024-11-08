package org.dam2.ejercicioMoviesJsonXml;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Movie> movies = leerJson();
		escribirXml(movies);
		
	}
	
	
	public static List<Movie> leerJson(){
		List<Movie> movies = new ArrayList<Movie>();
		try {
			Type listaDeObjetos = TypeToken.getParameterized(List.class, Movie.class).getType();
			GsonBuilder creadorGson = new GsonBuilder();
			creadorGson.registerTypeAdapter (LocalDate.class,new LocalDateAdapterJSON());
			creadorGson.registerTypeAdapter (Genre.class, new GenreAdapterJSON());
			Gson gson = creadorGson.create();
			movies = gson.fromJson(new FileReader("movies.json"), listaDeObjetos);
//			gson.toJson(movies,System.out);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return movies;
	}
	
	public static void escribirXml(List<Movie> movies) {
		Movies wrappermovies = new Movies(movies);
		
		try {
			Writer writer = new FileWriter("movies.xml");
			JAXBContext context = JAXBContext.newInstance(Movies.class);
			Marshaller ms = context.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(wrappermovies, writer);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		System.out.println("fichero escrito");

		
		
	}

}
