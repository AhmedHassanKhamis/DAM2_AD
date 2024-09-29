package org.dam2.streams.primerejercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppEjercicios {

	public static void main(String[] args) {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		final Consumer<Object> ESCRIBIDOR = System.out::println;
		final BiConsumer<Object, Object> ESCRIBIDOR2 = (obj1, obj2) -> {
			System.out.println(obj1 + "->" + obj2);
		};
		Runnable SINDATOS = () -> System.out.println("SIN DATOS");

		Alumno alumno;
		try (BufferedReader fichero = new BufferedReader(new FileReader("alumnos.csv"))) {

			while (fichero.ready()) {
				alumno = Alumno.fromCSV(fichero.readLine());
				alumnos.add(alumno);
			}

			/*
			 * alumnos = fichero.lines(). // obtener lineas de fichero como stream
			 * map(Alumno::fromCSV).// convertir la linea a un alumno toList();// convertir
			 * stream de alumnos a lista
			 */

		}

		catch (IOException e) {
			Pantalla.escribirString("\nError accediendo al fichero...");

		}

//		##################primer ejercicio
//		Function <String, String> sacarIniciales; 
//		sacarIniciales = s -> Stream.of(s.split(" ")).
//				map(n -> n.substring(0,1)).
//				map(String::toUpperCase).
//				reduce("",(s1,s2) -> s1+s2);
//		
//		alumnos.stream().
//			filter(Alumno::isRepetidor).
//			filter(Alumno::estaAprobado).
//			map(Alumno::getNombre).
//			map(sacarIniciales).
//			forEach(ESCRIBIDOR);
//		

//		##################segundo ejercicio
//		
//		alumnos.stream().
//				filter(a -> a.getFecha().isAfter(LocalDate.now().minusYears(18))).
//				map(Alumno::getCurso)
//				.distinct()
//				.forEach(ESCRIBIDOR);
//		

//		##################tercer ejercicio
//		alumnos.stream().collect(Collectors.groupingBy(Alumno::getCurso)).forEach(ESCRIBIDOR2);

//		##################cuarto ejercicio
//		alumnos.stream().collect(Collectors.groupingBy(Alumno::getCurso,Collectors.counting())).forEach(ESCRIBIDOR2);

//		##################QUINTO EJERCICIO
//		System.out.println(alumnos.stream().anyMatch(a -> a.getCurso().equalsIgnoreCase("DAM2"))?"Hay alumnos en DAM2":"No hay alumnos en DAM2");

//	    ##################SEXTO EJERCICIO
//		String curso, cursoActual;
//		Set<String> cursos = alumnos.stream().map(Alumno::getCurso).collect(Collectors.toSet());
//
//		do {
//			cursos.forEach(ESCRIBIDOR);
//			curso = Teclado.leerString("dame el curso");
//		} while (!cursos.contains(curso));
//
//		cursoActual = curso;
//
//		alumnos.stream().filter(a -> a.getCurso().equals(cursoActual))
//						.filter(Alumno::isRepetidor)
//						.min((a1, a2) -> Float.compare(a1.getNota(), a2.getNota()))
//						.ifPresentOrElse(ESCRIBIDOR, SINDATOS);

//		##################SEPTIMO EJERCICIO
		Map<String, Long> alumnosPorCursoMap = alumnos.stream()
				.collect(Collectors.groupingBy(Alumno::getCurso, Collectors.counting()));
		System.out.println("alumnos por curso:" + alumnosPorCursoMap);
		
		
		Stream<Entry<String, Long>> alumnosPorCursoStream = alumnosPorCursoMap.entrySet().stream();
		
		
		String cursoConMasAlumnos = alumnosPorCursoStream.max(Entry.comparingByValue((a, b) -> Long.compare(a, b)))
				.map(Entry::getKey).orElse("");
		System.out.println("curso con mas alumnos:" + cursoConMasAlumnos);
		
		System.out.println("nota media del curso con mas alumnos:");
		alumnos.stream().filter(a -> a.getCurso().equals(cursoConMasAlumnos)).mapToDouble(Alumno::getNota).average()
				.ifPresent(System.out::print);

	}

}
