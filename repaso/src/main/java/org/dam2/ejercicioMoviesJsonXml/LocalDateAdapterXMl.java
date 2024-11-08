package org.dam2.ejercicioMoviesJsonXml;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapterXMl extends XmlAdapter<String, LocalDate>{

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		
		LocalDate fecha = LocalDate.parse(v.toString());
		
		return fecha;
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		// TODO Auto-generated method stub
		
		if (v != null) {
			return v.toString();
		}else {
			return null;
		}
		
	}

}
