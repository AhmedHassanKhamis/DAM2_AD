package org.dam2.streams.primerejercicio;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppEjercicios {

	public static void main(String[] args) {
		List<Alumno> alumnos;
	/*
//		primer ejercicio
		Function <String, String> sacarIniciales; 
		sacarIninciales = s -> Stream.of(s.split(" ")).
				map(n -> n.substring(0,1)).
				map(String::toUpperCase).
				reduce("",(s1,s2) -> s1+s2);
		
		alumnos.stream().
			filter(Alumno::isRepetidor).
			filter(Alumno::estaAprobado).
			map(Alumno::getNombre).
			map(sacarIniciales).
			forEach(ESCRIBIDOR);
		*/
		
		
		
		
//		segundo ejercicio
		
//		alumno.stream().filter(a -> a.getFecha().isBefore(LocalDate.now().minusYears(18)).
//				map(Alumno::getCurso).distinct().forEach(ESCRIBIDOR);
//		
//		
		
//	QUINTO EJERCICIO
		System.out.println(alumno.stream().anyMatch(a -> a.getCurso().equalsIgnoreCase("DAM2"))?"Hay alumnos en DAM2":"No hay alumnos en DAM2");
		
		
//	SEXTO EJERCICIO
		String curso,cursoActual;
		Set<String> cursos = alumnos.stream().map(alumnos::getCurso).collect(Collectors.toSet());
		
		do {
			cursos.forEach(ESCRIBIDOR);
			curso = Teclado.leerString("dame el curso");
		} while (!cursos.contains(curso));
		
		cursoActual = curso;
		
		alumnos.stream(	).filter(a -> a.getCurso().equals(cursoActual)).filter(Alumno::isRepetidor).min((a1,a2)-> Float.compare(a1.compare(a1.getNota(),a2.getNota()))).ifPresentOrElse(ESCRIBIDOR,SINDATOS);
	}

}
