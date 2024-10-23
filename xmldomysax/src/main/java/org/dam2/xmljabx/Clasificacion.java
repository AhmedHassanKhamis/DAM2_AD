package org.dam2.xmljabx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD) // Permite poner las anotaciones en lo atributos
public class Clasificacion {
	@XmlAttribute
	private String edad;
	
	
//	@XmlValue
//	private String comentario;
//	
}
