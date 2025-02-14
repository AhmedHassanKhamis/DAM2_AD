package com.dam2.examenspring.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam2.examenspring.modelo.Cancion;
import com.dam2.examenspring.repositorio.CancionRepositorio;

@Service
public class CancionServicioImp implements ICancionServicio {
	
	@Autowired CancionRepositorio cancionDAO;

	@Override
	public boolean insert(Cancion cancion) {
		boolean exito = false;
		if (!cancionDAO.existsById(cancion.getTitulo())) {
			cancionDAO.save(cancion);
			exito = true;
		}
		return exito;
	}

}
