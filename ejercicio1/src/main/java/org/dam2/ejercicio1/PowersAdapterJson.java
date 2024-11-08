package org.dam2.ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class PowersAdapterJson extends TypeAdapter<Powers>  {

	@Override
	public void write(JsonWriter out, Powers value) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Powers read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println(in.peek());
		List<String> powersStringList = new ArrayList<String>();
		if (in.peek() == JsonToken.STRING) {
			powersStringList.add(in.nextString());
		}else {
			in.beginArray();
			while (in.hasNext()) {
				powersStringList.add(in.nextString());
			}
			in.endArray();
		}
		
		return new Powers(powersStringList);
	}

}
