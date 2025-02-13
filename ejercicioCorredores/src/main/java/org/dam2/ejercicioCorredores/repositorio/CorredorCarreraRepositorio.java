package org.dam2.ejercicioCorredores.repositorio;

import org.dam2.ejercicioCorredores.modelo.CorredorCarrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CorredorCarreraRepositorio extends CrudRepository<CorredorCarrera, Integer> {

}
