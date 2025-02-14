package org.dam2.ejercicioCorredores.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Carrera;
import org.dam2.ejercicioCorredores.modelo.Corredor;
import org.dam2.ejercicioCorredores.modelo.CorredorCarrera;
import org.springframework.transaction.annotation.Transactional;


public interface ICorredorCarreraServicio {
	
	@Transactional
	public boolean insert(CorredorCarrera corredorCarrera);	
	
	@Transactional
	public boolean anotarTiempo(CorredorCarrera corredorCarrera);
	
	public Optional<CorredorCarrera> buscarInscripcion(CorredorCarrera corredorCarrera);
	
	public List<CorredorCarrera> participacionesCarrera(String nombreCarrera);
	
	public List<String> listarPorOrdenLlegada();

}
