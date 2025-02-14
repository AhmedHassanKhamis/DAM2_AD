package com.dam2.examenspring.clienteApp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dam2.examenspring.modelo.Cancion;
import com.dam2.examenspring.modelo.Comentario;
import com.dam2.examenspring.modelo.Reproduccion;
import com.dam2.examenspring.modelo.Usuario;

import daw.com.Teclado;

public class PrimerClienteApp {
	
	private final static String URLBASE = "http://localhost:8080";

	public static void main(String[] args) {
		System.out.println("bienvenido a spotyAhmed!");
		Usuario usuario = Usuario.builder()
				.nickname(Teclado.leerString("Introduce tu nickname:"))
				.contrasenia(Teclado.leerString("Introduce tu contraseña:"))
				.build();
		
		if(verificarUsuario(usuario)) {
			escucharCancion(usuario);
		}else {
			usuario = registrarUsuario();
			escucharCancion(usuario);
		}
		
	}

	private static Usuario registrarUsuario() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Usuario> response;
		System.out.println("#####################################");
		System.out.println("FORMULARIO PARA REGISTRARSE:");
		System.out.println("#####################################");
		Usuario usuario = Usuario.builder()
				.nickname(Teclado.leerString("Introduce tu nickname:"))
				.contrasenia(Teclado.leerString("Introduce tu contraseña:"))
				.fechaNacimiento(LocalDate.parse(Teclado.leerString("INTRODUCE FECHA NACIMIENTO(YYYY-MM-DD):")))
				.build();
		try {
			response = restTemplate.postForEntity(URLBASE + "/usuario/registrar", usuario, Usuario.class);
			usuario = response.getBody();
			System.out.println("USUARIO REGISTRADO!!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("USUARIO NO REGISTRADO POR ERROR O YA EXISTE O ERES MENOR DE EDAD!!");
		}
		
		return usuario;
	}

	private static void escucharCancion(Usuario usuario) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Cancion[]> response;
		Cancion[] canciones;
		try {
			response = restTemplate.getForEntity(URLBASE + "/cancion/noEscuchadas/{nickName}", Cancion[].class, usuario.getNickname());
			canciones = response.getBody();
			System.out.println("-----LISTA DE CANCIONES SIN ESCUCHAR-----");
			Arrays.asList(canciones).forEach(c -> System.out.println(c.getTitulo()));
			String cancionSeleccionada = Teclado.leerString("Introduce el titulo de la cancion a escuchar:");
			String comentarioTexto = Teclado.leerString("Introduce tu comentario:");
			int puntuacion = 0;
			do {
				puntuacion = Teclado.leerInt("Puntuacion del 1 al 5:");
			} while (puntuacion > 5 && puntuacion < 1);
			Cancion cancion = Cancion.builder().titulo(cancionSeleccionada).build();
			Reproduccion reproduccion = Reproduccion.builder()
					.cancion(cancion)
					.usuario(usuario)
					.fechaReproduccion(LocalDateTime.now())
					.build();
			Comentario comentario = Comentario.builder()
					.cuerpo(comentarioTexto)
					.valoracion(puntuacion)
					.build();
			ResponseEntity<Comentario> responseComentario;
			responseComentario = restTemplate.postForEntity(URLBASE + "/comentario/insertar", comentario, Comentario.class);
			ResponseEntity<Reproduccion> responseReproducccion;
			responseReproducccion = restTemplate.postForEntity(URLBASE + "/reproduccion/realizar", reproduccion, Reproduccion.class);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("HA OCURRIDO UN ERROR REALIZANDO LA VISUALIZACION O EL COMENTARIO!");
		}
	}

	private static boolean verificarUsuario(Usuario usuario) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Usuario> response;
		boolean exito = false;
	
		try {
			response = restTemplate.postForEntity(URLBASE + "/usuario/consultar", usuario, Usuario.class);
			usuario = response.getBody();
			exito = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("USUARIO NO REGISTRADO O CREDENCIALES INCORRECTAS!!");
		}
		return exito;
	}

}
