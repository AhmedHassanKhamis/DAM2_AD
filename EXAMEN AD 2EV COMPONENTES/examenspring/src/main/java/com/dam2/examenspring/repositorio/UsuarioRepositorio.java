package com.dam2.examenspring.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam2.examenspring.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, String> {

	public Optional<Usuario> findByNicknameAndContrasenia(String nickname, String contrasenia);
	
}
