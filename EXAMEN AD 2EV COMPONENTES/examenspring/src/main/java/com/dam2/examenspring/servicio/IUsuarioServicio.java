package com.dam2.examenspring.servicio;

import java.util.Optional;

import com.dam2.examenspring.modelo.Usuario;

public interface IUsuarioServicio {
	
	public boolean insert(Usuario usuario);
	
	public Optional<Usuario> buscarPorNombreContrasenia(Usuario usuario);


}
