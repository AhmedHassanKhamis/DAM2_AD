package org.dam2.institutos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.opencsv.bean.CsvDate;

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
public class Persona {
	@CsvBindByPosition(position = 0)
	@EqualsAndHashCode.Include
	private String nif;
	@CsvBindByPosition(position = 1)
	private String nombre;
	@CsvBindByPosition(position = 2)
	@CsvDate("yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@CsvBindAndSplitByPosition(position = 3,
			elementType = Telefono.class, // tipo de elemento de la colección
			splitOn = "!",// separador de telefonos
			converter = CSVToTelefono.class,// Clase convertidora
			writeDelimiter = "!" // separador de telefonos
			)
	private List<Telefono> telefonos;
	@CsvCustomBindByPosition(position = 4,converter = CSVToOptional.class)
	private Optional<Vehiculo> vehiculo;
	
	public boolean addTelefono(Telefono telefono) {
		if(telefonos == null)
			telefonos = new ArrayList<Telefono>();
		return telefonos.add(telefono);
	}
	
	
}
