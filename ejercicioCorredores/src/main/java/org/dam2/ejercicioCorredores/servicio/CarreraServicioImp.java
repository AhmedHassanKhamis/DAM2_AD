package org.dam2.ejercicioCorredores.servicio;

import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Carrera;
import org.dam2.ejercicioCorredores.repositorio.CarreraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraServicioImp implements ICarreraServicio {

	@Autowired CarreraRepositorio carreraDAO;
	
	@Override
	public boolean insert(Carrera carrera) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (!carreraDAO.existsById(carrera.getNombreCarrera())) {
			carreraDAO.save(carrera);
			exito = true;
		}
		return exito;
	}

	@Override
	public Optional<Carrera> findById(String nombre) {
		// TODO Auto-generated method stub
		return carreraDAO.findById(nombre);
	}

}
