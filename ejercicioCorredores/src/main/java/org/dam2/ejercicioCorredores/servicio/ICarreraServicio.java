package org.dam2.ejercicioCorredores.servicio;

import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Carrera;

public interface ICarreraServicio {

	public boolean insert(Carrera carrera);
	
	public Optional<Carrera> findById(String nombre);
			
}
