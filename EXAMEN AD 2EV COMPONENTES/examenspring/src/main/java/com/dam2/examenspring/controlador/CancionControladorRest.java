package com.dam2.examenspring.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dam2.examenspring.modelo.Cancion;
import com.dam2.examenspring.modelo.Usuario;
import com.dam2.examenspring.servicio.IReproduccionServicio;

@RestController
@RequestMapping("/cancion")
public class CancionControladorRest {
	
	@Autowired IReproduccionServicio reproduccionServicio;
	
	@GetMapping("/noEscuchadas/{nickName}")
	public ResponseEntity<List<Cancion>> cancionesNoEscuchadas(@PathVariable String nickName){
		Usuario usuario = Usuario.builder().nickname(nickName).build();
		List<Cancion> noEscuchadas = reproduccionServicio.cancionesNoEscuchadas(usuario);
		
		if (!noEscuchadas.isEmpty()) {
			return new ResponseEntity<>(noEscuchadas, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
