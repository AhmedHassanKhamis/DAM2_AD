package org.dam2.ejercicioJson2;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
@XmlType (propOrder = { "id","mcr","nivel","horario","inicioImparticion","finParticion","horas","url","tipoFormacion","ects","categoria","profesorado"}) // orden en el xml, sino es alfabético
@XmlAccessorType(XmlAccessType.FIELD) // Permite poner las anotaciones en lo atributos
public class PruebaDeNivel {
	
	@XmlElement(name = "$id")
	@SerializedName(value = "$id")
	private String id;
	@XmlElement(name = "MCR")
	@SerializedName(value = "MCR")
	private String mcr;
	@XmlElement(name = "Nivel")
	@SerializedName(value = "Nivel")
	private String nivel;
	@XmlElement(name = "Horario")
	@SerializedName(value = "Horario")
	private String horario;
	@XmlElement(name = "Inicio_Imparticion")
	@SerializedName(value = "InicioImparticion")
	@XmlJavaTypeAdapter(LocalDateTimeXMLAdapter.class)
	private LocalDateTime inicioImparticion;
	@XmlElement(name = "Fin_Particion")
	@SerializedName(value = "FinParticion")
	@XmlJavaTypeAdapter(LocalDateTimeXMLAdapter.class)
	private LocalDateTime finParticion;
	@XmlElement(name = "Horas")
	@SerializedName(value = "Horas")
	private int horas;
	@XmlElement(name = "URL")
	@SerializedName(value = "URL")
	private String url;
	@XmlElement(name = "Tipo_Formacion")
	@SerializedName(value = "TipoFormacion")
	private TipoFormacion tipoFormacion;
	@XmlElement(name = "ECTS")
	@SerializedName(value = "ECTS")
	private String ects;
	@XmlElement(name = "Categoria")
	@SerializedName(value = "Categoria")
	private Categoria categoria;
	@XmlElement(name = "Profesorado")
	@SerializedName(value = "Profesorado")
	private Profesorado profesorado;
	

}
