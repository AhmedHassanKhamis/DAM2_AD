package org.dam2.pruebacontrolador.repository;

import org.dam2.pruebacontrolador.modelo.Noticia;
import org.dam2.pruebacontrolador.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UsuarioRepository extends CrudRepository<Usuario , String> {

}
