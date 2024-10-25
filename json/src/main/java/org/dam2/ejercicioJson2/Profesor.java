package org.dam2.ejercicioJson2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;

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
@XmlType (propOrder = { "id","nombreCompleto"}) // orden en el xml, sino es alfabético
@XmlAccessorType(XmlAccessType.FIELD) // Permite poner las anotaciones en lo atributos
public class Profesor {
	
	@EqualsAndHashCode.Include
	@XmlElement(name = "$id")
	@SerializedName(value = "$id")
	private String id;
	@XmlElement(name = "Nombre_completo")
	@SerializedName(value = "NombreCompleto")
	private String nombreCompleto;

}
