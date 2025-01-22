package org.dam2.pruebaspring.repositorio;

import java.util.List;
import java.util.Optional;

import org.dam2.pruebaspring.modelo.Alumno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepositorio extends CrudRepository<Alumno, String> {
	
	@Query("SELECT AVG(nota) From Alumno a")
	Optional<Float> calcularMedia();
	
	
//	@Query(nativeQuery = true, value = "select CURRENT_TIMESTAMP")
//	String fechadehoy();
	
	List<Alumno> findByNotaOrNombre(int nota, String nombre);
}
