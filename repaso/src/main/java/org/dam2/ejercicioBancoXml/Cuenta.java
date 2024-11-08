package org.dam2.ejercicioBancoXml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
@XmlAccessorType(XmlAccessType.FIELD)
public class Cuenta {
	
	@EqualsAndHashCode.Include
	@XmlAttribute
	private String ncc;
	private float saldo;
	private Tipo tipo;
	
	@XmlElement(name = "cliente")
	private List<Cliente> clientes;

}
