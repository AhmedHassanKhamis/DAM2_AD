package org.dam2.ejercicioCorredores.repositorio;

import java.util.List;

import org.dam2.ejercicioCorredores.modelo.Carrera;
import org.dam2.ejercicioCorredores.modelo.Corredor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CarreraRepositorio extends CrudRepository<Carrera, String> {

	
	
	@Query("select c.nombreCarrera From Carrera c where"
			+ " c.cupo > (select count(p) from CorredorCarrera p where p.carrera = c) "
			+ "AND c.nombreCarrera not in (select p.carrera.nombreCarrera from CorredorCarrera p where p.corredor = ?1)")
	public List<String> carrerasDisponibles (Corredor corredor);
}
