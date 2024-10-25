package org.dam2.ejercicioJson1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded =  true)	
@XmlType (propOrder = { "calle", "numero", "pais"}) // orden en el xml, sino es alfabético
@XmlAccessorType(XmlAccessType.FIELD) // Permite poner las anotaciones en lo atributos
public class Direccion {
	
	private String calle;
	private String numero;
	private String pais;
	
}
