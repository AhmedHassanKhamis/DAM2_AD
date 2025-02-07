package org.dam2.pruebacontrolador.service;

import java.util.List;

import org.dam2.pruebacontrolador.modelo.Comentario;
import org.dam2.pruebacontrolador.modelo.Noticia;
import org.dam2.pruebacontrolador.modelo.Usuario;
import org.dam2.pruebacontrolador.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
@Service
public class ComentarioServiceImpl implements IComentarioService {

	@Autowired ComentarioRepository comentarioDAO;

	@Override
	@Transactional
	public boolean insert(Comentario comentario) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (!comentarioDAO.existsById(comentario.getId())) {
			comentarioDAO.save(comentario);
			exito = true;
		}
		return exito;
	}

	@Override
	public boolean update(Comentario comentario) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (comentarioDAO.existsById(comentario.getId())) {
			comentarioDAO.save(comentario);
			exito = true;
		}
		return exito;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (comentarioDAO.existsById(id)) {
			comentarioDAO.deleteById(id);
			exito = true;
		}
		return exito;
	}

	@Override
	public List<Comentario> findAll() {
		// TODO Auto-generated method stub
		return (List<Comentario>) comentarioDAO.findAll();
	}

	@Override
	public List<Comentario> BuscarPorAutor(Usuario usuario) {
		// TODO Auto-generated method stub
		return comentarioDAO.findByAutor(usuario);
	}

	@Override
	public List<Comentario> BuscarPorNoticia(Noticia noticia) {
		// TODO Auto-generated method stub
		return comentarioDAO.findByNoticia(noticia);
	}

}
