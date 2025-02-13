package org.dam2.ejercicioCorredores.repositorio;

import org.dam2.ejercicioCorredores.modelo.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CarreraRepositorio extends CrudRepository<Carrera, String> {

}
