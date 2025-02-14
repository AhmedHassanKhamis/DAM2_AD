package org.dam2.ejercicioCorredores.controlador;

import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Corredor;
import org.dam2.ejercicioCorredores.servicio.ICorredorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/corredor")
public class CorredorControladorRest {

	@Autowired ICorredorServicio corredorServicio;
	
	@GetMapping("/consultar/{dni}")
	public ResponseEntity<Corredor> existeCorredor(@PathVariable String dni) {
		Optional<Corredor> corredor = corredorServicio.findById(dni);
		
		if (corredor.isPresent()) {
			return new ResponseEntity<>(corredor.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	
}
