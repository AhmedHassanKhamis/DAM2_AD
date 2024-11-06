package org.dam2.xmldomsax.cartelera;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EdadAdapter extends XmlAdapter<String, Edad> {

	@Override
	public Edad unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String marshal(Edad v) throws Exception {
		// TODO Auto-generated method stub
		return v.toString();
	}

}
