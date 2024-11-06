package org.dam2.xmldomsax.cartelera;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EnumGeneroAdapterXML extends XmlAdapter <String, Genero> {

	@Override
	public Genero unmarshal(String v)  {
		// TODO Auto-generated method stub
		
		return Genero.crearGenero(v);
	}

	@Override
	public String marshal(Genero v)  {
		// TODO Auto-generated method stub
		return v == null? null: v.toString();
	}

}
