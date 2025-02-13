package org.dam2.ejercicioCorredores.repositorio;

import org.dam2.ejercicioCorredores.modelo.Corredor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CorredorRepositorio extends CrudRepository<Corredor, String> {

}
