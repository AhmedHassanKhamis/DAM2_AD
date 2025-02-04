package org.dam2.pruebacontrolador.repository;

import org.dam2.pruebacontrolador.modelo.Noticia;
import org.dam2.pruebacontrolador.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UsuarioRepository extends CrudRepository<Usuario , String> {
	
	
	public Optional<Usuario> findByNickname(String nickname);
	
	@Query("SELECT u.nickname, MAX(u.puntos) FROM Usuario u")
	public List<Object[]> findUsuarioConMasPuntos();
	
	

	@Query("SELECT u FROM Usuario u JOIN FETCH u.noticias ORDER BY u.puntos DESC LIMIT 1")
	Optional<Usuario> findNoticiasDelUsuarioConMasPuntos();

	
}
