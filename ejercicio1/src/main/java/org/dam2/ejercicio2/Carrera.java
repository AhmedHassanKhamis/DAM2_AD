package org.dam2.ejercicio2;

import java.util.List;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Carrera {
	
	@CsvBindByPosition(position = 0)
	private String nombre;
	@CsvBindByPosition(position = 1)
	private int metros;
	@CsvBindByPosition(position = 2)
	private int cupo;
	@CsvBindAndSplitByPosition(position = 3,
			elementType= Corredor.class, //Tipo Elem. Colecc
			splitOn = "/", // separador de elementos
			converter = CorredorAdapter.class // Clase convertidora
			,writeDelimiter = "/")
	private List<Corredor> corredores;
	
	

}
