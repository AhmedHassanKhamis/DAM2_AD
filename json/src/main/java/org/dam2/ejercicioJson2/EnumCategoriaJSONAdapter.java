package org.dam2.ejercicioJson2;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class EnumCategoriaJSONAdapter extends  TypeAdapter<Categoria>{


	@Override
	public void write(JsonWriter out, Categoria value) throws IOException {
		// TODO Auto-generated method stub
		if(value != null)
			out.value(value.toString());
		else
			out.nullValue();
		
	}

	@Override
	public Categoria read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		return Categoria.crearCategoria(in.nextString());
	}

}
