package com.dam2.examenspring.controlador;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dam2.examenspring.modelo.Reproduccion;
import com.dam2.examenspring.modelo.Usuario;
import com.dam2.examenspring.servicio.IReproduccionServicio;

@RestController
@RequestMapping("/reproduccion")
public class ReproduccionControladorRest {

	@Autowired IReproduccionServicio reproduccionServicio;
	
	@PostMapping("/realizar")
	public ResponseEntity<Reproduccion> realizarReproduccion(@RequestBody Reproduccion reproduccion) {
		Optional<Reproduccion> reproduccionExiste = reproduccionServicio.buscarPorUsuarioCancionFecha(reproduccion);
		if (reproduccionExiste.isEmpty()) {
			if(reproduccionServicio.insert(reproduccion))
				return new ResponseEntity<>(reproduccion, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/estadisticas/{titulo}")
	public ResponseEntity<List<String>> estadisticasCancion(@PathVariable String titulo) {
		List<String> estadisticas = reproduccionServicio.estadisticasCancion(titulo);
		if (!estadisticas.isEmpty()) {
				return new ResponseEntity<>(estadisticas, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
}
