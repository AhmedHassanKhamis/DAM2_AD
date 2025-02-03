package org.dam2.pruebacontrolador;

import java.time.LocalDate;

import org.dam2.pruebacontrolador.modelo.Categoria;
import org.dam2.pruebacontrolador.modelo.Comentario;
import org.dam2.pruebacontrolador.modelo.Noticia;
import org.dam2.pruebacontrolador.modelo.Usuario;
import org.dam2.pruebacontrolador.service.IComentarioService;
import org.dam2.pruebacontrolador.service.INoticiaService;
import org.dam2.pruebacontrolador.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import daw.com.Teclado;

@Component
@Order(value = 1)
public class PRUEBA implements CommandLineRunner {

	@Autowired IUsuarioService usuarioService;
	@Autowired INoticiaService noticiaService;
	@Autowired IComentarioService comentarioService;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Noticia noticia = Noticia.builder()
				.titulo("peter el pitos")
				.cuerpo("peter el pitos tiene una pata como pito")
				.categoria(Categoria.CIENTIFICO)
				.fecha(LocalDate.now())
				.build();
		System.out.println(noticiaService.insert(noticia));
		
		Usuario usuario = Usuario.builder()
				.nickname("ahmedmega")
				.password("1234")
				.puntos(10)
				.noticia(noticia)
				.build();
		System.out.println(usuarioService.insert(usuario));
		
		
		Comentario comentario = Comentario.builder()
				.autor(usuario)
				.noticia(noticia)
				.fecha(LocalDate.now())
				.contenido("vaya noticia mas noticiosa")
				.valoracion(5)
				.build();
		
		
		System.out.println(comentarioService.insert(comentario));
		
		
		
		System.out.println(usuarioService.findAll());
		Teclado.leerString("PAUSA...");
		
		
		System.out.println(usuarioService.findUsuarioConMasPuntos());

	}

}
