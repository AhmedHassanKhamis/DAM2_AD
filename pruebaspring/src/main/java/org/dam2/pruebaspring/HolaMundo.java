package org.dam2.pruebaspring;

import java.time.LocalDate;

import org.dam2.pruebaspring.modelo.Alumno;
import org.dam2.pruebaspring.repositorio.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(value = 1)
public class HolaMundo implements CommandLineRunner {

	@Autowired
	private AlumnoRepositorio alumnoDAO;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("hola mundo!");
		Alumno a = Alumno.builder()
				.nia("001")
				.nombre("a1")
				.fecha(LocalDate.now())
				.nota(10)
				.build();
		
		
		alumnoDAO.save(a);
		
		//alumnoDAO.findAll().forEach(System.out::println);
		
		alumnoDAO.findByNotaOrNombre(10, "ahmed").forEach(System.out::println);
		
		System.out.println(alumnoDAO.calcularMedia().get());
	
		
	}

}
