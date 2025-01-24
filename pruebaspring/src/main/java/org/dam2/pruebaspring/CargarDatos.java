package org.dam2.pruebaspring;

import java.time.LocalDate;

import org.dam2.pruebaspring.modelo.Alumno;
import org.dam2.pruebaspring.servicios.IServicioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class CargarDatos implements CommandLineRunner {

	@Autowired
	@Qualifier(value = "otro")
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
		
		servicioAlumno.insertar(a);
		

		 a = Alumno.builder()
				.nia("002")
				.nombre("a2")
				.fecha(LocalDate.now().minusYears(10))
				.nota(8)
				.build();
		 
		servicioAlumno.insertar(a);

		
		
	}

}
