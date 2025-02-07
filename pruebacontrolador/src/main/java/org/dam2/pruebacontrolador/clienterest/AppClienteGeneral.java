package org.dam2.pruebacontrolador.clienterest;

import java.util.Arrays;
import java.util.List;

import org.dam2.pruebacontrolador.modelo.Comentario;
import org.dam2.pruebacontrolador.modelo.Noticia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


public class AppClienteGeneral {
	final static String URLBASE = "http://localhost:8080";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		redactarNoticia();
//		redactarComentario();
		verNoticiasDeCategoria("POLITICA");
//		EliminarNoticiasSinComentarios();

	}

	private static void EliminarNoticiasSinComentarios() {
		// TODO Auto-generated method stub
		String URLELIMINARNOTICIAS = URLBASE + "/noticia/borrarSinComentarios";
		RestTemplate restTemplate = new RestTemplate();

		String mensaje;

		try {

			ResponseEntity<Integer> response = restTemplate.getForEntity(URLELIMINARNOTICIAS, Integer.class);

			mensaje = response.getBody().toString();

		} catch (HttpClientErrorException e) {
			mensaje = "error borrando las noticias sin comentarios..." + e.getStatusCode();
		}

		System.out.println(mensaje);

	}

	private static void verNoticiasDeCategoria(String categoria) {
		// TODO Auto-generated method stub
		String URLNOTICIASCATEGORIA = URLBASE + "/noticia/categorias/{categoria}";
		RestTemplate restTemplate = new RestTemplate();
		Noticia[] noticias;
		
		ResponseEntity<Noticia[]> response  = 
				restTemplate.getForEntity(URLNOTICIASCATEGORIA, Noticia[].class, categoria);
		try {
			noticias = response.getBody();
			Arrays.stream(noticias).map(n -> n.getTitulo()).forEach(System.out::println);

		} catch (HttpClientErrorException e) {
			System.out.println("error " + e.getMessage());

		}
		 

	}

	private static void redactarComentario() {
		// TODO Auto-generated method stub
		String URLINSERTAR = URLBASE + "/insertar";
		Comentario comentario;
		RestTemplate restTemplate = new RestTemplate();


	}

	private static void redactarNoticia() {
		// TODO Auto-generated method stub
		String URLINSERTAR = URLBASE + "/insertar";
		Noticia noticia;
		RestTemplate restTemplate = new RestTemplate();
 

	}

}
