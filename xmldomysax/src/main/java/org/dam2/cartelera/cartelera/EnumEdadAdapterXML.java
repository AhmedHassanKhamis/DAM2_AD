package dam2.org.xmldomsax.cartelera;

import java.time.LocalDate;
import java.util.Arrays;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EnumEdadAdapterXML extends XmlAdapter <String, Edad> {

	@Override
	public Edad unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return Edad.crearEdad(v);
	}

	@Override
	public String marshal(Edad v) throws Exception {
		// TODO Auto-generated method stub
		return v== null?null:v.toString();
	}

}
