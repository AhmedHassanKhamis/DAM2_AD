package org.dam2.ejercicioCorredores.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Carrera;
import org.dam2.ejercicioCorredores.modelo.Corredor;
import org.dam2.ejercicioCorredores.modelo.CorredorCarrera;
import org.dam2.ejercicioCorredores.repositorio.CorredorCarreraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorredorCarreraServicioImp implements ICorredorCarreraServicio {

	@Autowired CorredorCarreraRepositorio corredorCarreraDAO;
	
	@Override
	public boolean insert(CorredorCarrera corredorCarrera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> carrerasDisponibles(Corredor corredor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Integer> siguienteDorsal(Carrera carrera) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<CorredorCarrera> participacionesCarrera(String nombreCarrera) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> listarPorOrdenLlegada() {
		// TODO Auto-generated method stub
		return null;
	}

}
