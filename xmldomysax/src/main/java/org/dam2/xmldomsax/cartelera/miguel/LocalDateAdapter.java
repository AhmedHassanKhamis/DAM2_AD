package org.dam2.xmldomsax.cartelera.miguel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter <String, LocalDate> {

	private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	@Override
	public LocalDate unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
	
		return LocalDate.parse(v,formato);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		// TODO Auto-generated method stub
		
		return v.format(formato);
	}
	

}
