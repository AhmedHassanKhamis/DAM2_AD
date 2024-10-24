package org.dam2.ejercicioTiempoSevila;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
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
@XmlType(propOrder = {"temperatura", "sensacionTermica", "icono", "condiciones", "viento", "probabilidadPrecipitacion", "precipitacion", "humedad"})
public class Hora {
	
//	PREGUNTAR SI SE TIENE QUE HACER UN UNICO ADAPTADOR PARA TODO EL TIPO DE FECHAS
	
	  
//	private LocalTime id;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@XmlAttribute
	private LocalTime id;

	
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@XmlAttribute
	private LocalDate fecha;
	
	private int temperatura;
	@XmlElement(name = "sensacion_termica")
	private int sensacionTermica;
	private String icono;
	private String condiciones;
	private Viento viento;
	@XmlElement(name = "probabilidad_precipitacion")
	private int probabilidadPrecipitacion;
	private float precipitacion;
	private int humedad;
	
	

}
