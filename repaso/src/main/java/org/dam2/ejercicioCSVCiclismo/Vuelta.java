package org.dam2.ejercicioCSVCiclismo;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

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
public class Vuelta {
	
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 0) 
	private String nombre;
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 1) 
	private int anio;
	@CsvBindByPosition(position = 2) 
	private float premio;
	@CsvBindByPosition(position = 3) 
	private String director;
	@CsvBindByPosition(position = 4) 
	private int numeroEtapas;
	@CsvBindAndSplitByPosition(position = 5,
			elementType= Equipo.class, // tipo de elemento de la colección
			splitOn = "#", // separador de elementos
			converter = CSVToEquipo.class, // Clase convertidora extends AbstractCsvConverter
			writeDelimiter = "#")
	private List<Equipo> equipos;

	public Vuelta(String nombre,int anio, float premio, String director, int numeroEtapas) {
		this.nombre = nombre;
		this.anio = anio;
		this.premio = premio;
		this.director = director;
		this.numeroEtapas = numeroEtapas;
		this.equipos = new ArrayList<Equipo>();
	}
	
	public boolean addEquipo(Equipo equipo) {
		if(equipos == null)
			equipos = new ArrayList<Equipo>();
		return equipos.add(equipo);
	}
	
}
