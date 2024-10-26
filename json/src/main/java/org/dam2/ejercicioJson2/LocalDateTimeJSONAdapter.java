package org.dam2.ejercicioJson2;

import java.io.IOException;
import java.time.LocalDateTime;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalDateTimeJSONAdapter extends TypeAdapter<LocalDateTime>{

	@Override
	public void write(JsonWriter out, LocalDateTime value) throws IOException {
		// TODO Auto-generated method stub
		if (value != null)
			out.value(value.toString());
		else
			out.nullValue();
		
		
	}

	@Override
	public LocalDateTime read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		return LocalDateTime.parse(in.nextString());
	}




	

}