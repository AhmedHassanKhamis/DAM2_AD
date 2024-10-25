package org.dam2.ejercicioJson1;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.dam2.json.Empleado;

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
@XmlType (propOrder = { "nombre", "altura", "peso", "pasatiempos","soltero","direccion"}) // orden en el xml, sino es alfabético
@XmlAccessorType(XmlAccessType.FIELD) // Permite poner las anotaciones en lo atributos
public class Persona {
	
	private String nombre;
	private float altura;
	private float peso;
	private List<String> pasatiempos;
	private boolean soltero;
	private Direccion direccion;
	

}
