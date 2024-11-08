package org.dam2.ejercicio2;

import java.time.LocalTime;
import java.util.List;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;

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
	private int edad;
	@CsvCustomBindByPosition(position=3,
			converter = CategoriaAdapter.class) 
	private Categoria categoria;
	@CsvCustomBindByPosition(position=4,
			converter = TiempoAdapter.class) 
	private LocalTime tiempo;
	
	

}
