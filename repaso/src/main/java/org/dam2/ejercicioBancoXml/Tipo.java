package org.dam2.ejercicioBancoXml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Tipo {
	@XmlEnumValue(value = "Personal")
	PERSONAL,
	@XmlEnumValue(value = "Empresa")
	EMPRESA,
	@XmlEnumValue(value = "Online")
	ONLINE;
	
	
	
	
}
