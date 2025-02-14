package com.dam2.examenspring.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam2.examenspring.modelo.Cancion;

@Repository
public interface CancionRepositorio extends CrudRepository<Cancion, String> {

}
