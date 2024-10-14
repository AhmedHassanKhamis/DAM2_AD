package org.dam2.ejercicioDepartEmpleados;

import java.time.LocalDate;
import java.util.HashSet;
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
	@EqualsAndHashCode.Include
	private String codigo;
	private String nombre;
	private String ciudad;
	private Set<Empleado> empleados;
	
	

	public Departamento(String codigo, String nombre, String ciudad) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.empleados = new HashSet<Empleado> ();
	}
	
	public boolean aniadirEmpleado(Empleado empleado) {
		return this.empleados.add(empleado);

	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad + "]";
	}
	
	
	
}
