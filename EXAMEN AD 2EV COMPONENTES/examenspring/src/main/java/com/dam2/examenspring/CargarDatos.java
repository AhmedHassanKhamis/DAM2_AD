package com.dam2.examenspring;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dam2.examenspring.modelo.Cancion;
import com.dam2.examenspring.modelo.Comentario;
import com.dam2.examenspring.modelo.Genero;
import com.dam2.examenspring.modelo.Reproduccion;
import com.dam2.examenspring.modelo.Usuario;
import com.dam2.examenspring.servicio.ICancionServicio;
import com.dam2.examenspring.servicio.IComentarioServicio;
import com.dam2.examenspring.servicio.IReproduccionServicio;
import com.dam2.examenspring.servicio.IUsuarioServicio;

import lombok.val;

@Component
@Order(value = 1)
public class CargarDatos implements CommandLineRunner {
	
	@Autowired IUsuarioServicio usuarioServicio;
	@Autowired IComentarioServicio comentarioServicio;
	@Autowired ICancionServicio cancionServicio;
	@Autowired IReproduccionServicio reproduccionServicio;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Usuario usuario = Usuario.builder()
				.nickname("ahmed")
				.contrasenia("123")
				.fechaNacimiento(LocalDate.of(2000, 2, 2))
				.build();
		
		
		Comentario comentario1 = Comentario.builder()
				.fechaComentario(LocalDate.now())
				.valoracion(7)
				.cuerpo("Mola!")
				.build();

		Comentario comentario2 = Comentario.builder()
				.fechaComentario(LocalDate.now().minusDays(10))
				.valoracion(-1)
				.cuerpo("no me gusta..")
				.build();

		Cancion cancion1 = Cancion.builder()
				.titulo("BackInBlack")
				.interprete("AC/DC")
				.genero(Genero.ROCK)
				.comentario(comentario1)
				.build();
		
		Cancion cancion2 = Cancion.builder()
				.titulo("TheNewWorkoutPlan")
				.interprete("Kanye West")
				.genero(Genero.RAP)
				.comentario(comentario2)
				.build();
		
		Reproduccion reproduccion1 = Reproduccion.builder()
				.cancion(cancion1)
				.usuario(usuario)
				.fechaReproduccion(LocalDateTime.now())
				.build();
		
		Reproduccion reproduccion2 = Reproduccion.builder()
				.cancion(cancion2)
				.usuario(usuario)
				.fechaReproduccion(LocalDateTime.now().minusMonths(2))
				.build();
		
		usuarioServicio.insert(usuario);
		
		comentarioServicio.insert(comentario1);
		comentarioServicio.insert(comentario2);
		
		cancionServicio.insert(cancion1);
		cancionServicio.insert(cancion2);
		
		reproduccionServicio.insert(reproduccion1);
		reproduccionServicio.insert(reproduccion2);
		

	}

}
