package org.dam2.pruebacontrolador.controlador;

import java.util.List;

import org.dam2.pruebacontrolador.modelo.Noticia;
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
@RequestMapping("/noticia")
public class NoticiaControladorRest {

	@Autowired
	INoticiaService noticiaServicio;
	@Autowired
	IUsuarioService usuarioServicio;

	@PostMapping("/insertar")
	public ResponseEntity<Noticia> insertarNoticia(@RequestBody Noticia noticia) {

		HttpStatus status = HttpStatus.CREATED;
		if (usuarioServicio.findById(noticia.getAutor().getNickname()).isPresent()) {
			if (!noticiaServicio.insert(noticia))
				status = HttpStatus.BAD_REQUEST;

		}else {
			status = HttpStatus.FORBIDDEN;
		}
		return new ResponseEntity<>(noticia, status);

	}

	@GetMapping("/categorias/{categoria}")
	public ResponseEntity<List<Noticia>> verNoticiasDeCategoria(@PathVariable String categoria) {
		ResponseEntity<List<Noticia>> response;
		List<Noticia> noticias;

		noticias = noticiaServicio.findByCategoria(categoria);

		if (!noticias.isEmpty())
			response = new ResponseEntity<>(noticias, HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return response;
	}
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Noticia>> listarNoticias() {
		ResponseEntity<List<Noticia>> response;
		List<Noticia> noticias;

		noticias = noticiaServicio.findAll();

		if (!noticias.isEmpty())
			response = new ResponseEntity<>(noticias, HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return response;
	}

	@GetMapping("/borrarSinComentarios")
	public ResponseEntity<Integer> borrarSinComentarios() {

		HttpStatus status = HttpStatus.OK;
		int afectados = noticiaServicio.deleteNoticiasSinComentarios();

		if (afectados == 0)
			status = HttpStatus.NO_CONTENT;

		return new ResponseEntity<>(afectados, status);
	}

}
