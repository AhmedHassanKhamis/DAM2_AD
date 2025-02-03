package org.dam2.pruebacontrolador.repository;

import java.util.List;

import org.dam2.pruebacontrolador.modelo.Comentario;
import org.dam2.pruebacontrolador.modelo.Noticia;
import org.dam2.pruebacontrolador.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface ComentarioRepository extends CrudRepository<Comentario, Integer> {

	public List<Comentario> findByAutor(Usuario autor);
	public List<Comentario> findByNoticia(Noticia noticia);
}
