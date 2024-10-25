package org.dam2.ejercicioJson2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeXMLAdapter extends XmlAdapter <String, Object>{

	@Override
	public Object unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
//		TENGO QUE FORMATEAR LAS FECHAS PARA DEVOLVER EL OBJETO
		if(v.contains("-") && v.contains(":")) {
			return LocalDateTime.parse(v,DateTimeFormatter.ISO_DATE_TIME);
		}
		else if(v.contains(":") && !v.contains("-")) {
			return LocalTime.parse(v,DateTimeFormatter.ISO_TIME);
		}else {
			return LocalDate.parse(v,DateTimeFormatter.ISO_DATE);
		}
	}

	@Override
	public String marshal(Object v) throws Exception {
		// TODO Auto-generated method stub
//		TENGO QUE FORMATEAR LAS FECHAS PARA DEVOLVER EL STRING 
		if(v.toString().contains("-") && v.toString().contains(":")) {
			return  ((LocalDateTime) v).format(DateTimeFormatter.ISO_DATE_TIME).toString();
		}
		else if(v.toString().contains(":") && !v.toString().contains("-")) 
			return ((LocalTime) v).format(DateTimeFormatter.ISO_TIME).toString();
		
		else
			return ((LocalDate) v).format(DateTimeFormatter.ISO_DATE).toString();
		
		
//		return (v == null)?null:v.toString();

	}


	

}
