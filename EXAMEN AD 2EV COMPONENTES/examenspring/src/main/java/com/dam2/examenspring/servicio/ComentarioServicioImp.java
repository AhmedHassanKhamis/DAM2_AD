package com.dam2.examenspring.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam2.examenspring.modelo.Comentario;
import com.dam2.examenspring.repositorio.CancionRepositorio;
import com.dam2.examenspring.repositorio.ComentarioRepositorio;

@Service
public class ComentarioServicioImp implements IComentarioServicio {

	@Autowired ComentarioRepositorio comentarioDAO;

	
	@Override
	public boolean insert(Comentario comentario) {
		boolean exito = false;
		if (!comentarioDAO.existsById(comentario.getIdComentario())) {
			comentarioDAO.save(comentario);
			exito = true;
		}
		return exito;
	}

}
