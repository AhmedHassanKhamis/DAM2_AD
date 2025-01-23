package org.dam2.pruebaspring.repositorio;

import java.util.List;
import java.util.Optional;

import org.dam2.pruebaspring.modelo.Alumno;
import org.dam2.pruebaspring.modelo.NiaYNombre;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface AlumnoRepositorio extends CrudRepository<Alumno, String> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Alumno a set a.nota = a.nota+1 where a.nota > ?1")
	int subirPunto(int notaCorte);
	
	@Query("SELECT AVG(nota) From Alumno a")
	Optional<Float> calcularMedia();
	
	
//	@Query(nativeQuery = true, value = "select CURRENT_TIMESTAMP")
//	String fechadehoy();
	
	List<Alumno> findByNotaOrNombre(int nota, String nombre);
	
	@Query("SELECT a.nia as nia,a. nombre as nombre FROM Alumno a ")
	List<NiaYNombre> listadoAlumnos();
	
	List<NiaYNombre> findByNombre(String nombre);
	
}
