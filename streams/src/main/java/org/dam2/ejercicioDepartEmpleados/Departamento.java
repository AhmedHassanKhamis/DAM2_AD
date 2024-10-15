package org.dam2.ejercicioDepartEmpleados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
		this.empleados = new HashSet<Empleado>();
	}

	public boolean aniadirEmpleado(Empleado empleado) {
		return this.empleados.add(empleado);

	}
	
	
	public boolean tieneEmpleados() {
		return (empleados != null && !empleados.isEmpty())? true:false;
	}

	public void ponerJefe() {
		if (empleados != null && !empleados.isEmpty()) {
			List<Empleado> conJefes = empleados.stream().filter(e -> e.tieneJefe()).toList();
			conJefes.stream().forEach((e) -> {
				e.setJefe(empleados.stream().filter(e2 -> e2.getDni().equalsIgnoreCase(e.getJefe().get().getDni()))
						.findFirst());

			});
		}
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad + "]";
	}

	public String toCSV() {
		String cadenaEmpleados = "";
		if (empleados != null && !empleados.isEmpty())
			cadenaEmpleados = empleados.stream().map(Empleado::toCSV).collect(Collectors.joining(""));
		return ((empleados == null) ? "0" : empleados.size()) + "#" + codigo + "%" + nombre + "%" + ciudad + "%"
				+ cadenaEmpleados + "\n";
	}

	public static Departamento fromCSV(String LineaCSV) {
		Departamento departamento = new Departamento();
		String[] cuantosEmpleados = LineaCSV.split("#");
		int numeroEmpleados = Integer.parseInt(cuantosEmpleados[0]);
		String[] campos = cuantosEmpleados[1].split("%");
		departamento.setCodigo(campos[0]);
		departamento.setNombre(campos[1]);
		departamento.setCiudad(campos[2]);
		if (campos.length > 3) {
			String[] empleadosString = null;
			if (campos[3] != null && campos[3].length() != 0)
				empleadosString = campos[3].split(";");
			Set<Empleado> empleados = new HashSet<Empleado>();
			if (empleadosString.length != 0 && empleadosString != null) {
				for (int i = 0; i < numeroEmpleados; i++) {
					empleados.add(Empleado.fromCSV(empleadosString[i]));
				}
			}
			departamento.setEmpleados(empleados);
		}
		return departamento;
	}

}
