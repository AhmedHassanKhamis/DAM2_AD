package org.dam2.pruebaspringBanco.repositorio;

import java.util.List;
import java.util.stream.Stream;

import org.dam2.pruebaspringBanco.modelo.Cliente;
import org.dam2.pruebaspringBanco.modelo.CompaniaTotal;
import org.dam2.pruebaspringBanco.modelo.Telefono;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, String> {

	List<Cliente> findByNombre(String nombre);
	
	@Query("SELECT c.telefonos FROM Cliente c where c.nif = ?1")
	List<Telefono> listadoTelefonos(String nia);
	
	@Transactional(readOnly = true)
	@Query("Select t.compania as compania, COUNT(t.compania) as total from Telefono t group by t.compania order by total desc")
	Stream<CompaniaTotal> mayorCompania();
}
