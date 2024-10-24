package org.dam2.ejercicioTiempoSevila;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
@XmlType(propOrder = {"temperatura", "viento", "precipitacion", "presion", "humedad"})

public class Dato {

//	PREGUNTAR SI SE TIENE QUE HACER UN UNICO ADAPTADOR PARA TODO EL TIPO DE FECHAS
	@XmlAttribute
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)  
//	private LocalDateTime fecha;
	private LocalDateTime fecha;

	
	private float temperatura;
	private Viento viento;
	private float precipitacion;
	private float presion;
	private int humedad;
	
	
	
	
	
}
