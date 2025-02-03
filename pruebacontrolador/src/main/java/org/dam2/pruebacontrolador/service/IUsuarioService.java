package org.dam2.pruebacontrolador.service;

import java.util.List;
import java.util.Optional;

import org.dam2.pruebacontrolador.modelo.Usuario;

import jakarta.transaction.Transactional;


public interface IUsuarioService {

	public boolean insert (Usuario usuario);
	
	public boolean update (Usuario usuario);
	
	public boolean delete (String id);
	
	@Transactional
	public List<Usuario> findAll ();
	
	public Optional <Usuario> findBynickname (String nif);
	
	public String findUsuarioConMasPuntos();
	
}
