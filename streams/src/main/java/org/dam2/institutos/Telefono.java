package org.dam2.institutos;

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
public class Telefono {
	@CsvBindByPosition(position = 0)
	@EqualsAndHashCode.Include
	private String numero;
	@CsvBindByPosition(position = 1)
	private String compania;
	@CsvBindByPosition(position = 2)
	private String sistema;
	

}
