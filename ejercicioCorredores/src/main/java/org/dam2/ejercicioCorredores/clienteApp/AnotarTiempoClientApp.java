package org.dam2.ejercicioCorredores.clienteApp;

import java.util.Arrays;
import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Carrera;
import org.dam2.ejercicioCorredores.modelo.CorredorCarrera;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import daw.com.Teclado;

public class AnotarTiempoClientApp {
	
	private static final String URLBASE = "http://localhost:8080";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Optional<Carrera> carrera = leerCarrera();
		if (carrera.isPresent()) {
			anotarTiempos(carrera.get());
		}else {
			System.out.println("Carrera no existe!");
		}
	}

	public static void anotarTiempos(Carrera carrera) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CorredorCarrera[]> response;
		CorredorCarrera[] inscripciones;
		try {
			response = restTemplate.getForEntity(URLBASE + "/inscripcion/tiempos/{nombreCarrera}", CorredorCarrera[].class, carrera.getNombreCarrera());
			inscripciones = response.getBody();
			Arrays.asList(inscripciones).forEach(i -> {
				ResponseEntity<String> response2;
				i.setTiempo(Teclado.leerInt("Introduce el tiempo para el corredor("+i.getCorredor().getDni()+"):"));
				response2 = restTemplate.postForEntity(URLBASE + "/inscripcion/anotarTiempo", i, String.class);
				System.out.println(response2.getBody());
			});
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fallo al traer las participaciones");
		}
		
		
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
	

}
