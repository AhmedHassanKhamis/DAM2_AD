package org.dam2.ejercicioTiempoSevila;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
@XmlRootElement
@XmlType (propOrder = { "localizacion", "condiciones", "alerta", "pronosticoDias", "pronosticoHoras","datosRegistrados"}) // orden en el xml, sino es alfabético
 // Permite poner las anotaciones en lo atributos
public class Tiempo {
	
//	@XmlAttribute
//	@XmlElement(name="titulo_original")
	
	@EqualsAndHashCode.Include
	private Localizacion localizacion;
	
	@XmlElement(name="condiciones_actuales")
	private CondicionesActuales condiciones;
	
	private String alerta;
	
	@XmlElement(name="pronostico_dias")
	private PronosticoDias pronosticoDias;
	
	@XmlElement(name="pronostico_horas")
	private PronosticoHoras pronosticoHoras;
	
	@XmlElement(name="datos_registrados")
	private DatosRegistrados datosRegistrados;
	

}
