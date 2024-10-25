package dam2.org.xmldomsax.cartelera;

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
