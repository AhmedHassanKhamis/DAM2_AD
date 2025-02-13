package org.dam2.ejercicioCorredores.repositorio;

import org.dam2.ejercicioCorredores.modelo.PuntoDeControl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PuntoDeControlRepositorio extends CrudRepository<PuntoDeControl, Float> {

}
