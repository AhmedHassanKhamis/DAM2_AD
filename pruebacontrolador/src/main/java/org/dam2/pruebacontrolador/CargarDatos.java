package org.dam2.pruebacontrolador;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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


@Component
@Order(value = 1)
public class CargarDatos implements CommandLineRunner {

	@Autowired IUsuarioService usuarioService;
	@Autowired INoticiaService noticiaService;
	@Autowired IComentarioService comentarioService;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		  // Crear usuarios
        Usuario usuario1 = Usuario.builder()
                .nickname("ahmedmega")
                .password("1234")
                .build();

        Usuario usuario2 = Usuario.builder()
                .nickname("juanito")
                .password("abcd")
                .build();

        Usuario usuario3 = Usuario.builder()
                .nickname("maria123")
                .password("pass123")
                .build();
        

        usuarioService.insert(usuario1);
        usuarioService.insert(usuario2);
        usuarioService.insert(usuario3);


        // Crear noticias
        Noticia noticia1 = Noticia.builder()
                .titulo("Peter el Pitos")
                .cuerpo("Peter el Pitos tiene muchos pitos para silbar en un partido de futbol.")
                .categoria(Categoria.DEPORTES)
                .fecha(LocalDate.now())
                .autor(usuario1)
                .build();

        Noticia noticia2 = Noticia.builder()
                .titulo("Descubrimiento en Marte")
                .cuerpo("Un nuevo descubrimiento en Marte podría cambiar la historia de la humanidad.")
                .categoria(Categoria.ECONOMIA)
                .fecha(LocalDate.now().minusDays(2))
                .autor(usuario2)
                .build();

        Noticia noticia3 = Noticia.builder()
                .titulo("El gato volador")
                .cuerpo("Un gato fue visto volando en una ciudad de Japón.")
                .categoria(Categoria.POLITICA)
                .fecha(LocalDate.now().minusDays(5))
                .autor(usuario3)
                .build();

        noticiaService.insert(noticia1);
        noticiaService.insert(noticia2);
        noticiaService.insert(noticia3);
        
        
        // Crear comentarios
        List<Comentario> comentarios = Arrays.asList(
                Comentario.builder()
                        .autor(usuario1)
                        .noticia(noticia1)
                        .fecha(LocalDate.now())
                        .contenido("Vaya noticia más noticiosa.")
                        .valoracion(45)
                        .build(),

                Comentario.builder()
                        .autor(usuario2)
                        .noticia(noticia1)
                        .fecha(LocalDate.now().minusDays(1))
                        .contenido("No estoy seguro de creer esto.")
                        .valoracion(3)
                        .build(),

                Comentario.builder()
                        .autor(usuario3)
                        .noticia(noticia2)
                        .fecha(LocalDate.now().minusDays(2))
                        .contenido("¡Increíble hallazgo en Marte!")
                        .valoracion(4)
                        .build(),

                Comentario.builder()
                        .autor(usuario1)
                        .noticia(noticia3)
                        .fecha(LocalDate.now().minusDays(3))
                        .contenido("Esto es claramente un montaje.")
                        .valoracion(2)
                        .build(),

                Comentario.builder()
                        .autor(usuario2)
                        .noticia(noticia3)
                        .fecha(LocalDate.now().minusDays(4))
                        .contenido("¡Quiero un gato así!")
                        .valoracion(5)
                        .build()
        );

        comentarios.forEach(comentarioService::insert);

        System.out.println("Datos de prueba insertados correctamente.");
		
		
		

	}

}
