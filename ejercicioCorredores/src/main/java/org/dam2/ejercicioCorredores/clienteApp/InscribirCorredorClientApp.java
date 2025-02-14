package org.dam2.ejercicioCorredores.clienteApp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Carrera;
import org.dam2.ejercicioCorredores.modelo.Corredor;
import org.dam2.ejercicioCorredores.modelo.CorredorCarrera;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import daw.com.Teclado;

public class InscribirCorredorClientApp {
	private static final String URLBASE = "http://localhost:8080";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Corredor corredor = leerCorredor();
		CorredorCarrera inscripcion;
		mostrarCarrerasDisponibles(corredor);
		
		Optional<Carrera> carrera = leerCarrera();
		
		if (carrera.isPresent()) {
			inscripcion = inscribir(corredor, carrera.get());
			System.out.println("INSCRIPCION COMPLETADA!!!\n Tu dorsal es:"+ inscripcion.getDorsal());
		} else {
			System.out.println("Fallo en la inscripcion: LA CARRERA INTRODUCIDA NO EXISTE!");
		}
		
	}
	
	
	private static void mostrarCarrerasDisponibles(Corredor corredor) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String[]> response;
		String[] carreras;
		
		try {
			response = restTemplate.getForEntity(URLBASE + "/carrera/disponibles/{dni}", String[].class, corredor.getDni());
			carreras = response.getBody();
			Arrays.asList(carreras).stream().forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("no hay carreras disponibles para este corredor");
		}

	}


	public static Corredor leerCorredor() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Corredor> response;
		Corredor corredor;

		String dni = Teclado.leerString("Introduce el dni del corredor");

		try {
			response = restTemplate.getForEntity(URLBASE+"/corredor/consultar/{dni}",Corredor.class,dni);
			
			corredor = response.getBody();

		} catch (Exception e) {
			// TODO: handle exception
			String nombre = Teclado.leerString("Nombre:");
			boolean sexo = Teclado.leerString("Hombre?").equalsIgnoreCase("s")?true:false;
			corredor = Corredor.builder()
					.dni(dni)
					.nombreCorredor(nombre)
					.sexo(sexo)
					.build();
		}
		
		return corredor;
	}
	
	public static Optional<Carrera> leerCarrera() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Carrera> response;
		Optional<Carrera> carrera;

		String nombre = Teclado.leerString("Introduce el nombre del la carrera");
		System.out.println(nombre);
		try {
			response = restTemplate.getForEntity(URLBASE+"/carrera/consultar/{nombreCarrera}",Carrera.class,nombre);
			
			carrera = Optional.of(response.getBody());

		} catch (Exception e) {
			// TODO: handle exception
			carrera = Optional.empty();
		}
		
		return carrera;
	}
	
	
	public static CorredorCarrera inscribir(Corredor corredor, Carrera carrera) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CorredorCarrera> response;
		CorredorCarrera inscripcion = CorredorCarrera.builder()
				.carrera(carrera)
				.corredor(corredor)
				.build();
		try {
			response = restTemplate.postForEntity(URLBASE + "/inscripcion/inscribir", inscripcion, CorredorCarrera.class);
			inscripcion = response.getBody();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error inscribiendo al corredor");
			
		}
		return inscripcion;
	}

}
