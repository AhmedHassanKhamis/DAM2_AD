package org.dam2.ejercicioTiempoSevila;

import java.time.LocalTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"ultimaObservacion","temperatura","sensacionTermica","condiciones","icono","viento","precipitacion","presion","humedad","visibilidad","indiceUltravioleta","puntoRocio"})
public class CondicionesActuales {
	private LocalTime ultimaObservacion;
	private float temperatura;
	private float sensacionTermica;
	private String condiciones;
	private String icono;
	private Viento viento;
	private float precipitacion;
	private float presion;
	private float humedad;
	private float visibilidad;
	private int indiceUltravioleta;
	private int puntoRocio;
}
