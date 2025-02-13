package org.dam2.ejercicioCorredores.servicio;

import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Corredor;

public interface ICorredorServicio {
	
	
	
	public boolean insert(Corredor corredor);
	
	public Optional<Corredor> findById(String dni);

}
