package com.dam2.examenspring.repositorio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam2.examenspring.modelo.Cancion;
import com.dam2.examenspring.modelo.Reproduccion;
import com.dam2.examenspring.modelo.Usuario;

@Repository
public interface ReproduccionRepositorio extends CrudRepository<Reproduccion, Integer> {

	
	public Optional<Reproduccion> findByFechaReproduccionAndUsuarioAndCancion(LocalDateTime fechaReproduccion, Usuario usuario, Cancion cancion);
	
	@Query("SELECT c from Cancion c where c not in (SELECT r.cancion FROM Reproduccion r where r.usuario = ?1)")
	public List<Cancion> cancionesNoEscuchadas(Usuario usuario);
	
	@Query("SELECT r.cancion.titulo, r.cancion.interprete, count(r.cancion) FROM Reproduccion r where r.cancion.titulo = ?1 group by r.cancion.titulo")
	public List<String> estadisticasCancion(String titulo);
}
