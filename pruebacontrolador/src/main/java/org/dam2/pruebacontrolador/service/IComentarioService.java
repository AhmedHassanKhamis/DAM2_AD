package org.dam2.pruebacontrolador.service;

import java.util.List;
import org.dam2.pruebacontrolador.modelo.Comentario;
import org.dam2.pruebacontrolador.modelo.Noticia;
import org.dam2.pruebacontrolador.modelo.Usuario;

public interface IComentarioService {
	public boolean insert (Comentario comentario);
	
	public boolean update (Comentario comentario);
	
	public boolean delete (int id);
	
	public List<Comentario> findAll ();
	
	public  List<Comentario> BuscarPorAutor (Usuario usuario);
	
	public  List<Comentario> BuscarPorNoticia (Noticia noticia);
	
}