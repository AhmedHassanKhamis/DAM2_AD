package org.dam2.ejercicioCSVCiclismo;

import java.time.LocalDate;
import java.util.List;

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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Corredor {
	
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 0)
	private String dni;
	@CsvBindByPosition(position = 1)
	private String nombre;
	@CsvBindByPosition(position = 2)
	@CsvDate("yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@CsvCustomBindByPosition(position=3,
			converter = BooleanAdapter.class)
			// extends AbstractBeanField<String, ElementoAAdaptar>
	private boolean profesional;
	
	
	

}
