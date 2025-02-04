package org.dam2.pruebacontrolador.service;

import java.util.List;
import java.util.Optional;

import org.dam2.pruebacontrolador.modelo.Noticia;
import org.springframework.transaction.annotation.Transactional;


public interface INoticiaService {
	public boolean insert (Noticia noticia);
	
	public boolean update (Noticia noticia);
	
	public boolean delete (String id);
	
	public List<Noticia> findAll ();
	
	public List<Noticia> findByTitulo (String titulo);
	
	@Transactional(readOnly = true)
	public List<String> findNoticiasDelMes();
	
	public Optional<Noticia> findNoticiaMasComentada();


}
