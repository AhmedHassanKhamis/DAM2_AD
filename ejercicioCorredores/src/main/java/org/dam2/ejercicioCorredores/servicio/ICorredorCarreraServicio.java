package org.dam2.ejercicioCorredores.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Carrera;
import org.dam2.ejercicioCorredores.modelo.Corredor;
import org.dam2.ejercicioCorredores.modelo.CorredorCarrera;

public interface ICorredorCarreraServicio {
	
	public boolean insert(CorredorCarrera CorredorCarrera);
	
	public List<String> carrerasDisponibles(Corredor corredor);
	
	public Optional<Integer> siguienteDorsal(Carrera carrera);
	
	public List<CorredorCarrera> participacionesCarrera(String nombreCarrera);
	
	public List<Object[]> listarPorOrdenLlegada();

}
