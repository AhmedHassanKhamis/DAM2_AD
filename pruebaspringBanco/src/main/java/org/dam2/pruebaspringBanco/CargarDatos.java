package org.dam2.pruebaspringBanco;

import org.dam2.pruebaspringBanco.modelo.Cliente;
import org.dam2.pruebaspringBanco.modelo.Telefono;
import org.dam2.pruebaspringBanco.servicios.IServicioCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(value = 1)
public class CargarDatos implements CommandLineRunner {

	@Autowired
	IServicioCliente servicioCliente;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Telefono telefono = Telefono.builder()
				.compania("Telefonica")
				.numero(666666666)
				.build();
		
		Cliente cliente = Cliente.builder()
				.nif("001a")
				.nombre("Luigi")
				.maxAval(100000)
				.telefono(telefono)
				.build();
		
		servicioCliente.insertar(cliente);
		
		 telefono = Telefono.builder()
				.compania("Orange")
				.numero(777777777)
				.build();
		
		 cliente = Cliente.builder()
				.nif("002b")
				.nombre("Marco")
				.maxAval(6000)
				.telefono(telefono)
				.build();
		 
		servicioCliente.insertar(cliente);
		
		
		 telefono = Telefono.builder()
					.compania("Telefonica")
					.numero(999999999)
					.build();
			
			 cliente = Cliente.builder()
					.nif("003c")
					.nombre("Pedro")
					.maxAval(26000)
					.telefono(telefono)
					.build();
			 
			servicioCliente.insertar(cliente);

	}

}
