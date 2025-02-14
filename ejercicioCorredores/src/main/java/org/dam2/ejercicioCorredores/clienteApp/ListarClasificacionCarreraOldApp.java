package org.dam2.ejercicioCorredores.clienteApp;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ListarClasificacionCarreraOldApp {

	private static final String URLBASE = "http://localhost:8080";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listarLlegadaDeCarreraMasAntigua();
	}

	private static void listarLlegadaDeCarreraMasAntigua() {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String[]> response;
		String[] resultados;
		
		try {
			response = restTemplate.getForEntity(URLBASE + "/inscripcion/listarOrdenLlegadaCarreraMasAntigua", String[].class);
			resultados = response.getBody();
			Arrays.asList(resultados).forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("no se pudo realizar la consulta debido a que esta vacia el resultado o ocurrio un error");
		}
		
	}

}
