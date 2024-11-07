package org.dam2.xmljabx.cartelera;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ClasificacionAdapter extends XmlAdapter<String, Clasificacion>{

	@Override
	public Clasificacion unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return (v == null)?new Clasificacion():new Clasificacion(v);
	}

	@Override
	public String marshal(Clasificacion v) throws Exception {
		// TODO Auto-generated method stub
		return (v == null)?null:v.getEdad().toString();
	}

}
