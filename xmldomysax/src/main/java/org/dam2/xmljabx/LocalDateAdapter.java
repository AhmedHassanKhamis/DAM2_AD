package org.dam2.xmljabx;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter <String, LocalDate>{

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
//		TENGO QUE FORMATEAR LAS FECHAS PARA DEVOLVER EL OBJETO
		return LocalDate.parse(v);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		// TODO Auto-generated method stub
//		TENGO QUE FORMATEAR LAS FECHAS PARA DEVOLVER EL STRING 

		return v.toString();
	}


	

}
