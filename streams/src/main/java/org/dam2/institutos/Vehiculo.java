package org.dam2.institutos;

import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
	@CsvBindByPosition(position = 0)
	private String matricula;
	@CsvBindByPosition(position = 1)
	private String modelo;
	@CsvBindByPosition(position = 2)
	private String color;
}
