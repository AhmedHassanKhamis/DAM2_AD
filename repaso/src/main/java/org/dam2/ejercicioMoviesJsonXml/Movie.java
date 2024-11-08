package org.dam2.ejercicioMoviesJsonXml;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {
	
	private String title;
	private int year;
	@XmlJavaTypeAdapter(value = GenreAdapterXML.class)
	private Genre genres;
	@XmlList
	private List<Integer> ratings;
	private String duration;
	@XmlJavaTypeAdapter(value = LocalDateAdapterXMl.class)
	private LocalDate releaseDate;
	private String originalTitle;
	private String storyline;
	@XmlList
	private List<String> actors;
	private String posterurl;
	
	

}
