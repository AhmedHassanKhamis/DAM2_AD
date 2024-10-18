package org.dam2.xmljabx;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
@XmlType (propOrder = { "titulo", "titulo_original", "nacionalidad", "genero","clasificacion","sinopsis","director","reparto","web","cartel"}) // orden en el xml, sino es alfabético
@XmlAccessorType(XmlAccessType.FIELD) // Permite poner las anotaciones en lo atributos
public class Pelicula {
	
	@EqualsAndHashCode.Include
	@XmlAttribute
	private String codigo;
	@XmlAttribute
	private int duracion;
	@XmlAttribute
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate fecha;
	
	private String titulo;
	@XmlElement(name="titulo_original")
	private String tituloOriginal;
	private String nacionalidad;
	private String genero;
	@XmlJavaTypeAdapter(ClasificacionAdapter.class)
	private Clasificacion clasificacion;
	private String sinopsis;
	private String director;
	
	@XmlElementWrapper(name="reparto")
	@XmlElement(name="empleado")
	private List<String> listaActores;
	
	private String web;
	private String cartel;
	
	
	public boolean addActor(String actor) {
		if(listaActores == null)
			listaActores = new ArrayList<String>();
		return listaActores.add(actor);
	}
	
	
	
	
	
	
	

}
