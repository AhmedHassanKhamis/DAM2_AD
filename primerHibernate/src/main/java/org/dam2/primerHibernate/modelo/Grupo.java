package org.dam2.primerHibernate.modelo;

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
public class Grupo {
	
	@EqualsAndHashCode.Include
	private String nombre;
	private String tutor;
	private int curso;
	private List<Alumno> alumnos;

}
