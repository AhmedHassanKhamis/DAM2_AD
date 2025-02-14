package org.dam2.ejercicioCorredores.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Carrera;
import org.dam2.ejercicioCorredores.modelo.Corredor;
import org.dam2.ejercicioCorredores.modelo.CorredorCarrera;
import org.dam2.ejercicioCorredores.repositorio.CarreraRepositorio;
import org.dam2.ejercicioCorredores.repositorio.CorredorCarreraRepositorio;
import org.dam2.ejercicioCorredores.repositorio.CorredorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CorredorCarreraServicioImp implements ICorredorCarreraServicio {

	@Autowired CorredorCarreraRepositorio corredorCarreraDAO;
	@Autowired CorredorRepositorio corredorDAO;
	@Autowired CarreraRepositorio carreraDAO;
	
	@Transactional
	@Override
	public boolean insert(CorredorCarrera corredorCarrera) {
		boolean exito = false;
		if (corredorDAO.existsById(corredorCarrera.getCorredor().getDni()) && 
			carreraDAO.existsById(corredorCarrera.getCarrera().getNombreCarrera())) {
			int dorsal = corredorCarreraDAO.sacarDorsal(corredorCarrera.getCarrera().getNombreCarrera());
			corredorCarrera.setDorsal(dorsal);
			corredorCarreraDAO.save(corredorCarrera);
			exito = true;
		}	
		return exito;
	}	
	
	@Override
	public boolean anotarTiempo(CorredorCarrera corredorCarrera) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (corredorCarreraDAO.findByCorredorAndCarrera(corredorCarrera.getCorredor(), corredorCarrera.getCarrera()).isPresent()) {
			corredorCarreraDAO.save(corredorCarrera);
			exito = true;
		}
		
		return exito;
	}

	@Override
	public List<CorredorCarrera> participacionesCarrera(String nombreCarrera) {
		// TODO Auto-generated method stub
		return corredorCarreraDAO.sacarParticipacionesdeunaCarreraParaAnotar(nombreCarrera);
	}

	@Override
	public List<String> listarPorOrdenLlegada() {
		// TODO Auto-generated method stub
		List<String> corredores = corredorCarreraDAO.listarOrdenLlegadaCarreraMasAntigua().stream()
				.map(c -> c[0] + "," + c[1]  + "," + c[2]).toList();
		return corredores;
	}

	@Override
	public Optional<CorredorCarrera> buscarInscripcion(CorredorCarrera inscripcion) {
		// TODO Auto-generated method stub
		return corredorCarreraDAO.findByCorredorAndCarrera(inscripcion.getCorredor(),inscripcion.getCarrera());
	}

	

	

}
