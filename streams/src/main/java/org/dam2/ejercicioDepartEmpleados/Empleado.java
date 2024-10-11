package org.dam2.ejercicioDepartEmpleados;

import java.time.LocalDate;
import java.util.Optional;

import org.dam2.streams.primerejercicio.Alumno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Empleado {
	@EqualsAndHashCode.Include
	private String dni;
	private String nombre;
	private String sexo;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIncorporacion;
	private Float salario;
	private Float comision;
	private String cargo;
	private Optional<Empleado> jefe;
	
	public Empleado(String dni, String nombre, String sexo, LocalDate fechaNacimiento, LocalDate fechaIncorporacion,
			float salario, float comision, String cargo, Empleado jefe) {
		this.dni = dni;
		this.nombre = nombre;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIncorporacion = fechaIncorporacion;
		this.salario = salario;
		this.comision = comision;
		this.cargo = cargo;
		this.jefe = Optional.ofNullable(jefe);
	}
	
	
	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaIncorporacion=" + fechaIncorporacion + ", salario=" + salario + ", comision=" + comision
				+ ", cargo=" + cargo + ", jefe=" + jefe.get().getDni() + "]";
	}
	
	
	
	
}
