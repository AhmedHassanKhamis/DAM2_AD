package org.dam2.primerHibernate.modelo;

import java.time.LocalDate;
import java.util.List;

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
public class Alumno {
	
	@EqualsAndHashCode.Include
	private String nia;
	private String nombre;
	private LocalDate fechaNacimiento;
	private boolean beca;

}
