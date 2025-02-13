package org.dam2.ejercicioCorredores.repositorio;

import java.util.List;

import org.dam2.ejercicioCorredores.modelo.CorredorCarrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CorredorCarreraRepositorio extends CrudRepository<CorredorCarrera, Integer> {

	@Query("select COALESCE(max(p.dorsal), 0)+1 from CorredorCarrera p where p.carrera.nombreCarrera = ?1")
	public Integer sacarDorsal(String nombreCarrera); 
	
	@Query("select c.corredor.nombre,c.corredor.dni,c.tiempo from CorredorCarrera c where c.carrera.fechaCelebracion = (select Min(j.fechaCelebracion) from Carrera j ) order by c.tiempo")
	public List<Object[]> listarOrdenLlegadaCarreraMasAntigua();
	
	@Query("select p from CorredorCarrera p where p.carrera.nombreCarrera = ?1 and p.tiempo = 0")
	public List<CorredorCarrera> sacarParticipacionesdeunaCarreraParaAnotar();
}
