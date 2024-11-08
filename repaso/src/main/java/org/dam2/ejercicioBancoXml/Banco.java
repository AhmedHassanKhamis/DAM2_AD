package org.dam2.ejercicioBancoXml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Banco {
	
	@EqualsAndHashCode.Include
	@XmlAttribute
	private String nombre;
	
	@XmlElementWrapper(name = "cuentas")
	@XmlElement(name = "cuenta")
	private List<Cuenta> cuentas;
	
}
