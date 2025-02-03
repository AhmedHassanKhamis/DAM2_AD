package org.dam2.pruebacontrolador.service;

import java.util.List;
import java.util.Optional;

import org.dam2.pruebacontrolador.modelo.Usuario;
import org.dam2.pruebacontrolador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired  UsuarioRepository usuarioDAO;

	@Override
	public boolean insert(Usuario usuario) {

		// TODO Auto-generated method stub
		boolean exito = false;

		if (!usuarioDAO.existsById(usuario.getNickname())) {
			usuarioDAO.save(usuario);
			exito = true;
		}

		return exito;
	}

	@Override
	public boolean update(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean exito = false;

		if (usuarioDAO.existsById(usuario.getNickname())) {
			usuarioDAO.save(usuario);
			exito = true;
		}

		return exito;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		boolean exito = false;

		if (usuarioDAO.existsById(id)) {
			usuarioDAO.deleteById(id);
			exito = true;
		}

		return exito;
		
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	public Optional<Usuario> findBynickname(String nif) {
		// TODO Auto-generated method stub
		return usuarioDAO.findByNickname(nif);
	}

	@Override
	public String findUsuarioConMasPuntos() {
		// TODO Auto-generated method stub
		List<Object[]> usuario = usuarioDAO.findUsuarioConMasPuntos();
		
		return (String) usuario.get(0)[0];
	}

}
