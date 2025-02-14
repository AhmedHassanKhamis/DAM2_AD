package com.dam2.examenspring.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam2.examenspring.modelo.Cancion;
import com.dam2.examenspring.modelo.Reproduccion;
import com.dam2.examenspring.modelo.Usuario;
import com.dam2.examenspring.repositorio.ComentarioRepositorio;
import com.dam2.examenspring.repositorio.ReproduccionRepositorio;

@Service
public class ReproduccionServicioImp implements IReproduccionServicio {

	@Autowired ReproduccionRepositorio reproduccionDAO;

	
	@Override
	public boolean insert(Reproduccion reproduccion) {
		boolean exito = false;
		if (reproduccionDAO.findByFechaReproduccionAndUsuarioAndCancion(
				reproduccion.getFechaReproduccion(),
				reproduccion.getUsuario(),
				reproduccion.getCancion()).isEmpty()) {
			reproduccionDAO.save(reproduccion);
			exito = true;
		}
		return exito;
	}


	@Override
	public List<Cancion> cancionesNoEscuchadas(Usuario usuario) {
		// TODO Auto-generated method stub
		return reproduccionDAO.cancionesNoEscuchadas(usuario);
	}


	@Override
	public Optional<Reproduccion> buscarPorUsuarioCancionFecha(Reproduccion reproduccion) {
		// TODO Auto-generated method stub
		return reproduccionDAO.findByFechaReproduccionAndUsuarioAndCancion(reproduccion.getFechaReproduccion(), reproduccion.getUsuario(), reproduccion.getCancion());
	}


	@Override
	public List<String> estadisticasCancion(String cancion) {
		// TODO Auto-generated method stub
		return reproduccionDAO.estadisticasCancion(cancion);
	}

}
