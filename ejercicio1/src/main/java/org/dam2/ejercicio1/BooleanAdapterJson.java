package org.dam2.ejercicio1;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class BooleanAdapterJson extends TypeAdapter<Boolean>{

	@Override
	public void write(JsonWriter out, Boolean value) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		if(in.nextString().equalsIgnoreCase("On"))
			return true;
		else
			return false;
	}

}
