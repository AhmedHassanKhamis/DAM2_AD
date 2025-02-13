package org.dam2.ejercicioCorredores.servicio;

import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Corredor;
import org.dam2.ejercicioCorredores.repositorio.CorredorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorredorServicioImp implements ICorredorServicio {
	
	@Autowired CorredorRepositorio corredorDAO;

	@Override
	public boolean insert(Corredor corredor) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (!corredorDAO.existsById(corredor.getDni())) {
			corredorDAO.save(corredor);
			exito = true;
		}
		return exito;
	}

	@Override
	public Optional<Corredor> findById(String dni) {
		// TODO Auto-generated method stub
		return corredorDAO.findById(dni);
	}

}
