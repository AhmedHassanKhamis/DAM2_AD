package org.dam2.pruebaspringBanco.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.dam2.pruebaspringBanco.modelo.Cliente;
import org.dam2.pruebaspringBanco.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioClienteImpl implements IServicioCliente {

	@Autowired
	ClienteRepositorio clienteDAO;

	@Override
	public boolean insertar(Cliente c) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (!clienteDAO.existsById(c.getNif())) {
			clienteDAO.save(c);
			exito = true;
		}
		return false;
	}

	@Override
	public boolean actualizar(Cliente c) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (clienteDAO.existsById(c.getNif())) {
			clienteDAO.save(c);
			exito = true;
		}
		return false;
	}

	@Override
	public boolean borrar(Cliente c) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (clienteDAO.existsById(c.getNif())) {
			clienteDAO.delete(c);
			exito = true;
		}
		return false;
	}

	@Override
	public Optional<Cliente> buscarPorClave(String nif) {
		// TODO Auto-generated method stub
		return clienteDAO.findById(nif) ;
	}

	@Override
	public Stream<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		List<Cliente> clientes = (List<Cliente>) clienteDAO.findAll();
		return clientes.stream();
	}

	@Override
	public Optional<String> mayorCompania() {
		// TODO Auto-generated method stub
		String mayorCompania = clienteDAO.mayorCompania().findFirst().map(c -> c[0] + "->" + c[1]).toString();
		return Optional.of(mayorCompania);
	}

}
