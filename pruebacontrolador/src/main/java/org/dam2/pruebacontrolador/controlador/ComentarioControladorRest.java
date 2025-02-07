package org.dam2.pruebacontrolador.controlador;

import java.util.List;

import org.dam2.pruebacontrolador.modelo.Comentario;
import org.dam2.pruebacontrolador.modelo.Noticia;
import org.dam2.pruebacontrolador.service.IComentarioService;
import org.dam2.pruebacontrolador.service.INoticiaService;
import org.dam2.pruebacontrolador.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentario")
public class ComentarioControladorRest {

	@Autowired
	IComentarioService comentarioServicio;
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	INoticiaService noticiaService;

	@PostMapping("/insertar")
	public ResponseEntity<Comentario> insertarNoticia(@RequestBody Comentario comentario) {

		HttpStatus status = HttpStatus.CREATED;
		if (usuarioService.findById(comentario.getAutor().getNickname()).isPresent()) {
			if (!noticiaService.findById(comentario.getNoticia().getIdNoticia()).isEmpty()) {
				if (!comentarioServicio.insert(comentario))
					status = HttpStatus.BAD_REQUEST;
			} else {
				status = HttpStatus.NOT_FOUND;
			}
		} else {
			System.out.println("no encontré el usuario");
			status = HttpStatus.FORBIDDEN;
		}

		return new ResponseEntity<>(comentario, status);
	}

	@GetMapping("/listar/{idNoticia}")
	public ResponseEntity<List<Comentario>> listarComentariosDeUnaNoticia(@PathVariable int idNoticia) {
		List<Comentario> comentarios = null;
		HttpStatus status = HttpStatus.CREATED;
		if (!noticiaService.findById(idNoticia).isEmpty()) {
			comentarios = comentarioServicio.BuscarPorNoticia(Noticia.builder().idNoticia(idNoticia).build());
			if (comentarios.isEmpty())
				status = HttpStatus.NO_CONTENT;
		} else {
			status = HttpStatus.NOT_FOUND;
		}

		return new ResponseEntity<>(comentarios, status);
	}
}
