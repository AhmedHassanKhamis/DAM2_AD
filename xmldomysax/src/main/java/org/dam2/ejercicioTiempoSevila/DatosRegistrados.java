package org.dam2.ejercicioTiempoSevila;

import java.time.LocalDateTime;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.dam2.xmljabx.LocalDateAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class DatosRegistrados {
	
	@XmlJavaTypeAdapter(LocalDateAdapter.class) 
	@XmlAttribute
	private LocalDateTime actualizacion;
	
	
	@XmlElement(name="dato")
	private List<Dato> datos_registrados;

}
