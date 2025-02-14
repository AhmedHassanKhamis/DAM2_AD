package org.dam2.ejercicioCorredores.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Carrera;
import org.dam2.ejercicioCorredores.modelo.Corredor;

public interface ICarreraServicio {

	public boolean insert(Carrera carrera);
	
	public Optional<Carrera> findById(String nombre);
	
	public List<String> carrerasDisponibles(Corredor corredor);

			
}
