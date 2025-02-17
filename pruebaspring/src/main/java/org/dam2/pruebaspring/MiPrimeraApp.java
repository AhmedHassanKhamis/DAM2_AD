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
@Order(value = 2)
public class MiPrimeraApp implements CommandLineRunner {
	
	@Autowired
	@Qualifier(value = "labuena")
	IServicioAlumno servicioAlumno;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
				
		
		servicioAlumno.buscarPorClave("021").ifPresentOrElse(System.out::println, ()-> System.out.println("No existe el dato!"));
		
		servicioAlumno.buscarTodos().forEach(System.out::println);
		
		
		
	}

}
