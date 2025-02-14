package com.dam2.examenspring.clienteApp;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dam2.examenspring.modelo.Usuario;

import daw.com.Teclado;

public class SegundoClienteApp {

	private final static String URLBASE = "http://localhost:8080";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		infoCancion(Teclado.leerString("Introduce el titulo de una cancion:"));
	}

	private static void infoCancion(String titulo) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String[]> response;
		String[] estadisticas;
		try {
			response = restTemplate.getForEntity(URLBASE + "/reproduccion/estadisticas/{titulo}", String[].class, titulo);
			estadisticas = response.getBody();
			Arrays.asList(estadisticas).forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("CANCION NO ENCONTRADA!!!!");
		}
		
	}

}
