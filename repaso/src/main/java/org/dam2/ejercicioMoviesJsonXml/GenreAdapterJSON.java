package org.dam2.ejercicioMoviesJsonXml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class GenreAdapterJSON extends TypeAdapter<Genre> {

	@Override
	public void write(JsonWriter out, Genre value) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Genre read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		
		Genre genero = new Genre();
		List<String> generos = new ArrayList<String>();
		if (in.peek() == JsonToken.STRING) {
			generos.add(in.nextString());
		}else {
			in.beginArray();
			while (in.hasNext()) {
				generos.add(in.nextString());
			}
			in.endArray();
		}
		
		genero.setGenres(generos);
		return genero;
	}

}
