package org.dam2.ejercicioTiempoSevila;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EnumDireccionAdapter extends XmlAdapter<String, Direccion> {

	@Override
	public Direccion unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return Direccion.crearDireccion(v);
	}

	@Override
	public String marshal(Direccion v) throws Exception {
		// TODO Auto-generated method stub
		return v== null?null:v.toString();
	}

}
