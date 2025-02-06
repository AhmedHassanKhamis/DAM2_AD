package org.dam2.pruebacontrolador.controlador;

import org.dam2.pruebacontrolador.modelo.Comentario;
import org.dam2.pruebacontrolador.service.IComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/comentario")
public class ComentarioControladorRest {

	
	@Autowired IComentarioService cometarioServicio;
	
	@PostMapping("/insertar")
	public ResponseEntity<Comentario> insertarNoticia (@RequestBody Comentario comentario)
	{
		
		HttpStatus status = HttpStatus.CREATED;
		
		if (!cometarioServicio.insert(comentario))
			status = HttpStatus.BAD_REQUEST;
		
		
		return new ResponseEntity<>(comentario,status);
	}
}
