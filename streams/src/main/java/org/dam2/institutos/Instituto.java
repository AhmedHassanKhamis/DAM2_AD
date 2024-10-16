package org.dam2.institutos;

import java.util.HashSet;
import java.util.Set;


import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Instituto {
	
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 0)
	private String codigo;
	@CsvBindByPosition(position = 1)
	private String nombre;
	@CsvBindByPosition(position = 2)
	private int numero;
	@CsvBindByPosition(position = 3)
	private float presupuesto;
	@CsvBindAndSplitByPosition(position = 4,
			elementType = Persona.class, // tipo de elemento de la colección
			splitOn = ";",// separador de empleados
			converter = CSVToPersona.class,// Clase convertidora
			writeDelimiter = ";")
	private Set<Persona> personas;
	
	
	
	public boolean addPersona(Persona persona) {
		if(personas == null)
			personas = new HashSet<Persona>();
		return personas.add(persona);
	}
	
	
	
}
