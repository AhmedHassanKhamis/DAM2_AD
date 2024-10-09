package org.dam2.ejercicioOpenCsv;

import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class instituto {

	@CsvBindByPosition(position = 0)
	private String nombre;
	@CsvBindByPosition(position = 1)
	private String codigo;
	@CsvBindByPosition(position = 2)
	private int numeroTelefono;
	@CsvBindByPosition(position = 3)
	private Float presupuesto;
	
}
