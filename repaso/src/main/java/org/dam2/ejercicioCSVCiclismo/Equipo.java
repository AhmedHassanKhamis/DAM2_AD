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
public class Equipo {

	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 1) 
	private String nombre;
	@CsvBindByPosition(position = 2) 
	private String nombrePatrocinador;
	@CsvBindByPosition(position = 3) 
	private String nacionalidad;
	@CsvBindByPosition(position = 4) 
	private float donacion;
	@CsvBindAndSplitByPosition(position = 6,
			elementType= Corredor.class, // tipo de elemento de la colección
			splitOn = ";", // separador de elementos
			converter = CSVToCorredor.class, // Clase convertidora extends AbstractCsvConverter
			writeDelimiter = ";")
	private List<Corredor> corredores;
	
	public Equipo(String nombre, String nombrePatrocinador, String nacionalidad, float donacion) {
		this.nombre = nombre;
		this.nombrePatrocinador = nombrePatrocinador;
		this.nacionalidad = nacionalidad;
		this.corredores = new ArrayList<Corredor>();
	}
	

	
}
