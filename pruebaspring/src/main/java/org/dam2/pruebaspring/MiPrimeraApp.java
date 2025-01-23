package org.dam2.pruebaspring;

import java.time.LocalDate;

import org.dam2.pruebaspring.modelo.Alumno;
import org.dam2.pruebaspring.servicios.IServicioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MiPrimeraApp implements CommandLineRunner {
	
	@Autowired
	IServicioAlumno servicioAlumno;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Alumno a = Alumno.builder()
				.nia("001")
				.nombre("a1")
				.fecha(LocalDate.now())
				.nota(10)
				.build();
		
		
		System.out.println(servicioAlumno.insertar(a));
		
		System.out.println(servicioAlumno.insertar(a));

	}

}
