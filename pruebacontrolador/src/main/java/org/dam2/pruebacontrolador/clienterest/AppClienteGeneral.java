package org.dam2.pruebacontrolador.clienterest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.dam2.pruebacontrolador.modelo.Categoria;
import org.dam2.pruebacontrolador.modelo.Comentario;
import org.dam2.pruebacontrolador.modelo.Noticia;
import org.dam2.pruebacontrolador.modelo.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import daw.com.Teclado;

public class AppClienteGeneral {
	final static String URLBASE = "http://localhost:8080";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		redactarNoticia();
//		redactarComentario();
		verComentarioDeNoticiasDeUnaCategoria();
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

	private static void verComentarioDeNoticiasDeUnaCategoria() {
		// TODO Auto-generated method stub
		String URLNOTICIASCATEGORIA = URLBASE + "/noticia/categorias/{categoria}";
		RestTemplate restTemplate = new RestTemplate();
		Noticia[] noticias;
		Comentario[] comentarios;
		String categoria = Teclado.leerString("Categoria(deportes/politica/economia):");
		ResponseEntity<Noticia[]> response = restTemplate.getForEntity(URLNOTICIASCATEGORIA, Noticia[].class,
				categoria);
		try {
			noticias = response.getBody();
			Arrays.stream(noticias).map(n -> "id:" + n.getIdNoticia() + ", " + n.getTitulo()).forEach(System.out::println);

		} catch (HttpClientErrorException e) {
			System.out.println("error " + e.getMessage());

		}
		String idNoticia = Teclado.leerString("IdNoticia:");
		ResponseEntity<Comentario[]> response2 = restTemplate.getForEntity(URLBASE + "/comentario/listar/{idNoticia}", Comentario[].class,
				idNoticia);
		try {
			comentarios = response2.getBody();
			Arrays.stream(comentarios).map(c -> c.getAutor() + ", fecha:"+ c.getFecha()+ "\n valoracion: " + c.getValoracion() + "\n contenido:" + c.getContenido() + "-----------------------------------------------------\n").forEach(System.out::println);

		} catch (HttpClientErrorException e) {
			System.out.println("error " + e.getMessage());

		}

	}

	private static void redactarComentario() {
		// TODO Auto-generated method stub
		String URLINSERTAR = URLBASE + "/comentario/insertar";
		RestTemplate restTemplate = new RestTemplate();
		Usuario usuario = Usuario.builder().nickname(Teclado.leerString("Nickname:")).build();
		boolean exito = true;
		try {
			ResponseEntity<Noticia[]> response = restTemplate.getForEntity(URLBASE + "/noticia/listar",
					Noticia[].class);
			Arrays.stream(response.getBody())
					.map(n -> "id:" + n.getIdNoticia() + ", " + n.getTitulo() + ":\n" + n.getCuerpo() + "\n\n")
					.forEach(System.out::println);
		} catch (HttpClientErrorException e) {
			System.out.println("Error, listando noticias:" + e);
			exito = false;
		}
		if (exito) {
			// Insertar entidad
			Noticia noticia = Noticia.builder().idNoticia(Teclado.leerInt("Id noticia:")).build();
			Comentario comentario = Comentario.builder().autor(usuario).noticia(noticia).fecha(LocalDate.now())
					.contenido(Teclado.leerString("cuerpo comentario:")).valoracion(Teclado.leerInt("valoracion(1-5):"))
					.build();
			try {

				restTemplate.postForObject(URLINSERTAR, comentario, Comentario.class);

				System.out.println("Comentario insertado correctamente");

			} catch (HttpClientErrorException e) {
				System.out.println("Error, insertando comentario:" + e);
			}
		}

	}

	private static void redactarNoticia() {
		// TODO Auto-generated method stub
		String URLINSERTAR = URLBASE + "/noticia/insertar";
		RestTemplate restTemplate = new RestTemplate();
		Usuario usuario = Usuario.builder().nickname(Teclado.leerString("Nickname:")).build();
		Categoria categoria = null;
		boolean exito = true;
		String titulo = Teclado.leerString("Titulo:");
		String cuerpo = Teclado.leerString("Cuerpo:");
		do {
			switch (Teclado.leerString("Categoria:(deportes,politica,economia)?").toLowerCase()) {
			case "deportes":
				exito = true;
				categoria = Categoria.DEPORTES;
				break;
			case "politica":
				exito = true;
				categoria = Categoria.POLITICA;
				break;
			case "economia":
				exito = true;
				categoria = Categoria.ECONOMIA;
				break;
			default:
				exito = false;
				System.out.println("Error: categoria incorrecta!");
				break;
			}
		} while (exito == false);
		Noticia noticia = Noticia.builder().autor(usuario).categoria(categoria).fecha(LocalDate.now()).titulo(titulo)
				.cuerpo(cuerpo).build();

		// Insertar entidad
		try {
			restTemplate.postForObject(URLINSERTAR, noticia, Noticia.class);

			System.out.println("noticia insertada correctamente");

		} catch (HttpClientErrorException e) {
			System.out.println("Error, insertando noticia:" + e);
		}
	}

}
