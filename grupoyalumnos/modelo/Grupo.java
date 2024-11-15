package org.dam2.grupoyalumnos.modelo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Grupo {
	@EqualsAndHashCode.Include
	@NonNull
	private String nombre;
	private String tutor;	
	private int curso;
	@Singular
	List<Alumno> alumnos;
	

}
