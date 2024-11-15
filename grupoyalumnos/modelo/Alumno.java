package org.dam2.grupoyalumnos.modelo;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Alumno {
	@EqualsAndHashCode.Include
	@NonNull
	private String nia;
	
	private String nombre;
	private LocalDate fechaNacimiento;
	private boolean beca;

}
