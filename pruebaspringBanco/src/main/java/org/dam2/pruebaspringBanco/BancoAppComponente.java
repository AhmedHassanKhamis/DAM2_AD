package org.dam2.pruebaspringBanco;

import org.dam2.pruebaspringBanco.servicios.IServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class BancoAppComponente implements CommandLineRunner {

	@Autowired
	IServicioCliente servicioCliente;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		System.out.println(servicioCliente.mayorCompania());
	}

}
