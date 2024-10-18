package org.dam2.xmljabx;

import java.util.Optional;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class OptionalAdapter extends XmlAdapter<String, Optional<String>> {

	@Override
	public Optional<String> unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public String marshal(Optional<String> v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
