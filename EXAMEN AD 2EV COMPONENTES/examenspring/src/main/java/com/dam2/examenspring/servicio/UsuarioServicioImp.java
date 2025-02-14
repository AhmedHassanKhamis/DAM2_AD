package com.dam2.examenspring.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam2.examenspring.modelo.Usuario;
import com.dam2.examenspring.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImp implements IUsuarioServicio {
	
	@Autowired UsuarioRepositorio usuarioDAO;

	@Override
	public boolean insert(Usuario usuario) {
		boolean exito = false;
		if (!usuarioDAO.existsById(usuario.getNickname())) {
			usuarioDAO.save(usuario);
			exito = true;
		}
		return exito;
	}

	@Override
	public Optional<Usuario> buscarPorNombreContrasenia(Usuario usuario) {
		// TODO Auto-generated method stub
		
		return usuarioDAO.findByNicknameAndContrasenia(usuario.getNickname(), usuario.getContrasenia());
	}

}
