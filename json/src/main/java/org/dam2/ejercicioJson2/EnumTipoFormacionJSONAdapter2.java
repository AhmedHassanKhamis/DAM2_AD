package org.dam2.ejercicioJson2;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EnumTipoFormacionJSONAdapter2 extends XmlAdapter<String, TipoFormacion>{

	@Override
	public TipoFormacion unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return TipoFormacion.crearTipoFormacion(v);
	}

	@Override
	public String marshal(TipoFormacion v) throws Exception {
		// TODO Auto-generated method stub
		return v == null?  null: v.toString();
	}

}
