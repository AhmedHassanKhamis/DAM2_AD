package org.dam2.pruebaspring.servicios;

import java.util.Optional;
import java.util.stream.Stream;

import org.dam2.pruebaspring.modelo.Alumno;
import org.springframework.stereotype.Service;
public interface IServicioAlumno {
	
	boolean insertar (Alumno a);
	
	boolean actualizar(Alumno a);
	boolean borrar(String nia);
	Optional<Alumno> buscarPorClave(String nia);
	
	Stream<Alumno> buscarTodos();
	
	int sumarUnPunto (int nota);
	
	
	Optional<Float> calcularMedia();
	
	
}   
