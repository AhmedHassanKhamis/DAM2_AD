package org.dam2.ejercicioDepartEmpleados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import daw.com.Teclado;

public class App {

	public static void main(String[] args) {
			List<Departamento> departamentos = cargarDepartamentos();
			
//			1) Obtener los datos completos de los todos los empleados por orden alfabético.
			
//			List<Empleado> empleados = departamentos.stream()
//					.flatMap(d -> d.getEmpleados().stream())
//					.sorted((e1,e2)->e1.getNombre().compareTo(e2.getNombre()))
//					.toList();
//			
//			System.out.println(empleados);
//			
			
			
//			2) Obtener el nombre y cargo de todos los empleados, ordenado por salario.

//			departamentos.stream().flatMap(d-> d.getEmpleados().stream()).sorted((e1,e2)-> Float.compare(e1.getSalario(), e2.getSalario())).forEach(e -> System.out.println(e.getNombre()+"->"+e.getCargo()));
			
//			3) Listar los salarios y comisiones de los empleados del departamento introducido por teclado.
//			String Buscar =  Teclado.leerString("Nombre del departamento a buscar:");
//			departamentos.stream().filter(d -> d.getNombre().equalsIgnoreCase(Buscar)).flatMap(d -> d.getEmpleados().stream()).forEach(e -> System.out.println(e.getNombre()+"->"+e.getSalario()+"->"+e.getComision()));;
			
//			4) Obtener el valor total a pagar que resulta de sumar a los empleados del departamento introducido
//			por teclado, una bonificación de 500000€, en orden alfabético del empleado.
//			String Buscar =  Teclado.leerString("Nombre del departamento a buscar:");
//			
//			
//			departamentos.stream()
//			.filter(d -> d.getNombre().equalsIgnoreCase(Buscar))
//			.flatMap(d -> d.getEmpleados().stream())
//			.sorted((e1,e2) -> e1.getNombre().compareTo(e2.getNombre()))
//			.map((e) ->{ 
//				e.setSalario(e.getSalario() + 50000f);
//				return e;
//			})
//			.forEach(e-> System.out.println(e.getNombre() + "->" + e.getSalario()));
			
//			Double suma = departamentos.stream()
//			.filter(d -> d.getNombre().equalsIgnoreCase(Buscar))
//			.flatMap(d -> d.getEmpleados().stream())
//			.sorted((e1,e2) -> e1.getNombre().compareTo(e2.getNombre()))
//			.mapToDouble(Empleado::getSalario)
//			.map(v -> v + 50000f)
//			.sum();
//			System.out.println(suma);
//			
			
			
			
//			5) Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
			
//			departamentos.stream().flatMap(d -> d.getEmpleados().stream()).filter(e -> e.getComision() > e.getSalario()).forEach(System.out::println);

			
//			6) Obtener los nombres de los departamentos que hay en cada ciudad.
//			departamentos.stream().collect(Collectors.groupingBy(Departamento::getCiudad)).entrySet().stream().forEach(System.out::println);

			
//			7) Hallar el salario más alto, el más bajo y la diferencia entre ellos.
//			Optional<Empleado> masAlto = departamentos.stream().flatMap(d -> d.getEmpleados().stream()).max((e1,e2) -> e1.getSalario().compareTo(e2.getSalario()));
//			Optional<Empleado> masBajo = departamentos.stream().flatMap(d -> d.getEmpleados().stream()).min((e1,e2) -> e1.getSalario().compareTo(e2.getSalario()));
//			
//			System.out.println(masAlto);
//			System.out.println(masBajo);
//			System.out.println("Diferencia->"+ (masAlto.get().getSalario() - masBajo.get().getSalario()));
			
			
//			8) Entregar el número de empleados de sexo femenino y de sexo masculino.
			
//			System.out.println(departamentos.stream().flatMap(d -> d.getEmpleados().stream()).distinct().collect(Collectors.groupingBy(Empleado::getSexo,Collectors.counting())));
			
//			9) Entregar el nombre del departamento cuya suma de salarios sea la más alta, indicando el valor
//			de la suma.
//			
//			Optional<Departamento> departamentoRico = departamentos.stream().max((d1,d2) ->  Double.compare(d1.getEmpleados().stream().mapToDouble(Empleado::getSalario).sum(), d2.getEmpleados().stream().mapToDouble(Empleado::getSalario).sum()));
//			System.out.println(departamentoRico.get().getNombre()+"->"+  departamentoRico.get().getEmpleados().stream().mapToDouble(Empleado::getSalario).sum());
			
//			10) Obtener la lista de empleados jefes, que tienen al menos un empleado a su cargo.
//			
//			departamentos.stream().flatMap(d->d.getEmpleados().stream()).distinct().filter(e -> e.getJefe().isEmpty()).forEach(System.out::println);
			
//			11) Hallar el salario promedio por departamento.
//			
//			departamentos.stream().collect(Collectors.groupingBy(Departamento::getNombre,Collectors.summingDouble(d -> d.getEmpleados().stream().mapToDouble(Empleado::getSalario).average().orElse(0)))).forEach((k,v) -> System.out.println(k +"->" +v ));
			
//			12) Obtener información de los empleados cuyo nombre tiene exactamente 11 caracteres.
			
//			departamentos.stream().flatMap(d->d.getEmpleados().stream()).filter(e -> e.getNombre().length() == 11).forEach(System.out::println);

			
//			13) Entregar el total a pagar por comisiones, y el número de empleados que las reciben.
//			System.out.println("Total a pagar en comisiones por departamento:");
//			departamentos.stream().collect(Collectors.groupingBy(Departamento::getNombre,Collectors.summingDouble(d -> d.getEmpleados().stream().mapToDouble(Empleado::getComision).sum()))).forEach((k,v) -> System.out.println(k + "->" + v));;
//			System.out.println("\n\nEmpleados que la reciben:");
//			departamentos.stream().collect(Collectors.groupingBy(Departamento::getNombre,Collectors.summingDouble(d -> d.getEmpleados().stream().count()))).forEach((k,v) -> System.out.println(k + "->" + v));;
			
			
			
//			14) Suponer que la empresa va a aplicar un reajuste salarial del 7%. Listar los nombres de los
//			empleados, su salario actual y su nuevo salario, indicando para cada uno de ellos si tiene o no
//			comisión.
			departamentos.stream().
			flatMap(d -> d.getEmpleados().stream()).
			forEach (e -> System.out.println (e.getNombre() + 
								"->" + 
								e.getSalario() + 
								"->" + 
								(e.getSalario() * 1.07) +
								"->" +
								(e.getComision()> 0?"tiene comisi�n":"no tiene comisi�n")));
	}

	
	
	public 	static List<Departamento> cargarDepartamentos(){
		final Optional<Empleado> SINJEFE = Optional.empty();
		List<Departamento> departamentos = new ArrayList<Departamento>();
		Empleado empleado1,empleado2,empleado3;
		Departamento departamento1,departamento2,departamento3;
		
		departamento1 = new Departamento("1", "IoT", "Madrid");
		empleado1 = new Empleado("1" , "Angela", "mujer", LocalDate.parse("2002-05-15"), LocalDate.parse("2024-09-15"), 100000f, 1000000f, "Manager", SINJEFE);
		empleado2 = new  Empleado("2" , "Lucas", "hombre", LocalDate.parse("2000-06-25"), LocalDate.parse("2024-09-15"), 30000f, 0, "Ventas", empleado1);
		empleado3 = new Empleado("3", "Daddy", "hombre", LocalDate.parse("2001-07-30"), LocalDate.parse("2024-09-15"), 50000f, 750f, "Marketing", empleado1);
		
		departamento1.aniadirEmpleado(empleado3);
		departamento1.aniadirEmpleado(empleado2);
		departamento1.aniadirEmpleado(empleado1);
		departamentos.add(departamento1);
		
		departamento1 = new Departamento("2", "BigData", "Galicia");
		empleado1 = new Empleado("4" , "Alba", "mujer", LocalDate.parse("2002-05-15"), LocalDate.parse("2024-09-15"), 40000f, 1000f, "Manager", SINJEFE);
		empleado2 = new  Empleado("5" , "Eduardo", "hombre", LocalDate.parse("2000-06-25"), LocalDate.parse("2024-09-15"), 20000f, 500f, "Ventas", empleado1);
		empleado3 = new Empleado("6", "Johanesburg", "hombre", LocalDate.parse("2001-07-30"), LocalDate.parse("2024-09-15"), 70000f, 750f, "Marketing", empleado1);
		
		departamento1.aniadirEmpleado(empleado3);
		departamento1.aniadirEmpleado(empleado2);
		departamento1.aniadirEmpleado(empleado1);
		departamentos.add(departamento1);
		
		

		departamento1 = new Departamento("3", "Caixa", "Barcelona");
		departamentos.add(departamento1);
		departamento1 = new Departamento("4", "BBVA", "Madrid");
		departamentos.add(departamento1);
		departamento1 = new Departamento("5", "CajaMadrid", "Pamplona");
		departamentos.add(departamento1);
		departamento1 = new Departamento("6", "RadioOlé", "Barcelona");
		departamentos.add(departamento1);

		return departamentos;
		
	}
}
