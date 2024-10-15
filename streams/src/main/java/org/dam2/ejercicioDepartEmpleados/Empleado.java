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
	
	
	public Empleado(String dni) {
		this.dni = dni;
	}
	
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
	
	public boolean tieneJefe() {
		if(!jefe.isEmpty())
			return !jefe.get().getDni().equalsIgnoreCase("SIN JEFE");
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaIncorporacion=" + fechaIncorporacion + ", salario=" + salario + ", comision=" + comision
				+ ", cargo=" + cargo + ", jefe=" + jefe.map(Empleado::getNombre).orElse("SIN JEFE") + "]\n";
	}
	
	public String toCSV() {
		return dni + "," + nombre + "," + sexo + "," + fechaNacimiento + "," + fechaIncorporacion + "," + salario + "," + comision + "," + cargo + "," + jefe.map(Empleado::getDni).orElse("SIN JEFE") + ";";
	}
	
	public static Empleado fromCSV(String LineaCSV) {
		Empleado empleado = new Empleado();
		String [] campos = LineaCSV.split(",");
		empleado.setDni(campos[0]);
		empleado.setNombre(campos[1]);
		empleado.setSexo(campos[2]);
		empleado.setFechaNacimiento(LocalDate.parse(campos[3]));
		empleado.setFechaIncorporacion(LocalDate.parse(campos[4]));
		empleado.setSalario(Float.parseFloat(campos[5]));
		empleado.setComision(Float.parseFloat(campos[6]));
		empleado.setCargo(campos[7]);
		if(campos[8].equalsIgnoreCase("SIN JEFE"))
			empleado.setJefe(Optional.empty());
		else
			empleado.setJefe(Optional.of(new Empleado(campos[8])));
		return empleado;		
	}
	
}
