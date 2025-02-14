package com.dam2.examenspring.controlador;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dam2.examenspring.modelo.Comentario;
import com.dam2.examenspring.modelo.Usuario;
import com.dam2.examenspring.servicio.IComentarioServicio;

@RestController
@RequestMapping("/comentario")
public class ComentarioControladorRest {
	
	@Autowired IComentarioServicio comentarioServicio;
	
	@PostMapping("/insertar")
	public ResponseEntity<Comentario> insertarComentario(@RequestBody Comentario comentario) {
		if (comentarioServicio.insert(comentario)) {
			return new ResponseEntity<> (comentario,HttpStatus.OK);
		}else {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
