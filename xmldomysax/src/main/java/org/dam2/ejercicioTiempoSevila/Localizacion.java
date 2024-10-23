package org.dam2.ejercicioTiempoSevila;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"ciudad","latitud","longitud"})
public class Localizacion {

	@EqualsAndHashCode.Include
	@XmlAttribute
	private String id;
	private String ciudad;
	private Float latitud;
	private Float longitud;
	
	
}
