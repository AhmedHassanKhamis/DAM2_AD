package org.dam2.json;

import java.io.IOException;
import java.time.LocalDate;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;import lombok.val;

public class LocalDateSplitValuesAdapter extends TypeAdapter<LocalDate> {

	@Override
	public void write(JsonWriter out, LocalDate value) throws IOException {
		// TODO Auto-generated method stub
		out.beginObject();
		out.name("dia");
		out.value(value.getDayOfMonth());
		out.name("mes");
		out.value(value.getMonthValue());
		out.name("anio");
		out.value(value.getYear());
		out.endObject();
	}

	@Override
	public LocalDate read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		int dia,mes,anio;
		
//		in.peek() == JsonToken.BEGIN_OBJECT;  -> para saber que token es el siguiente por si es una clave o un valor de tipo int string y 
		
		in.beginObject();
//		NO TIENE PORQUE VENIR ORDENADO
		in.nextName(); //leo la clave dia
		dia = in.nextInt();
		in.nextName(); //leo la clave mes
		mes = in.nextInt();
		in.nextName();//leo la clave anio
		anio = in.nextInt();
		in.endObject();
		
		return LocalDate.of(anio, mes, dia);
	}

}
