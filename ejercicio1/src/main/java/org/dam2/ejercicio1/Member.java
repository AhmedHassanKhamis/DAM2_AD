package org.dam2.ejercicio1;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Member {

	@XmlAttribute
	private String name;
	private int age;
	private String secretIdentity;
//	@XmlJavaTypeAdapter(value = PowersAdapterXml.class)
	private Powers powers;
	
	
	
	
}
