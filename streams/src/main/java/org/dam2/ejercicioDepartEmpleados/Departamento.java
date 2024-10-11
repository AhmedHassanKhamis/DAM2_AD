package org.dam2.ejercicioDepartEmpleados;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Departamento {
	private int codigoDepartamento;
	private String nombre;
	private String ciudad;
	private Set<Empleado> empleados;
	
	
	public boolean aniadirEmpleado(Empleado empleado) {
		return this.empleados.add(empleado);

	}
}
