package org.dam2.ejercicioCorredores;

import org.dam2.ejercicioCorredores.modelo.PuntoDeControl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class cargarDatos implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		PuntoDeControl punto = PuntoDeControl.builder()
				.km(44f)
				.juez("peter")
				.primerCorredor(null)
				.tiempo(7500)
				.build();
		
		System.out.println(punto.tiempoHorasMinutosSegundos());

	}

}
