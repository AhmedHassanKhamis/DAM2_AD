package org.dam2.pruebaspringBanco.servicios;

import java.util.Optional;
import java.util.stream.Stream;

import org.dam2.pruebaspringBanco.modelo.Cliente;

public interface IServicioCliente {
	
	boolean insertar(Cliente c);
	
	boolean actualizar(Cliente c);
	
	boolean borrar(Cliente c);
	
	Optional<Cliente> buscarPorClave(String nif);
	
	Stream<Cliente> buscarTodos();
	
	Optional<String> mayorCompania();

}
