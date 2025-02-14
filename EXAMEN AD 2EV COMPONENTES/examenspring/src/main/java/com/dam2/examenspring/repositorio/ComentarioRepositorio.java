package com.dam2.examenspring.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam2.examenspring.modelo.Comentario;

@Repository
public interface ComentarioRepositorio extends CrudRepository<Comentario, Integer> {

}
