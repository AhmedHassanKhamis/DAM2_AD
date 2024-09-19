package org.dam2.prueba;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

public class Grupo {
	@EqualsAndHashCode.Include
	@NonNull
	private String nombre;
	@Singular()
	private Set<Alumno> alumnos;
	
	public void addAlumno (Alumno alumno) {
		Set<Alumno> alumnosTemp = new HashSet <>(alumnos);
		alumnosTemp.add(alumno);
		alumnos = alumnosTemp;
	}
	
}
