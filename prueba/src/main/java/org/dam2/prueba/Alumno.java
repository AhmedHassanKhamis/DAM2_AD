package org.dam2.prueba;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor //constructor con parametros
@NoArgsConstructor //constructor sin parametros
@RequiredArgsConstructor //constructor con todos los parametros no nulos 
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Alumno {
	@EqualsAndHashCode.Include
	@NonNull
	private String dni;
	private String nombre;
	private int edad;
	
}
