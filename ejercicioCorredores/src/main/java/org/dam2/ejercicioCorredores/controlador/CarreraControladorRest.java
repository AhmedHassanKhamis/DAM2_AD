package org.dam2.ejercicioCorredores.controlador;

import java.util.List;
import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Carrera;
import org.dam2.ejercicioCorredores.modelo.Corredor;
import org.dam2.ejercicioCorredores.servicio.ICarreraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/carrera")
public class CarreraControladorRest {

	@Autowired ICarreraServicio carreraServicio;
	
	
	@GetMapping("/disponibles/{dni}")
	public ResponseEntity<List<String>> carrerasDisponibles(@PathVariable String dni){
		Corredor corredor = Corredor.builder().dni(dni).build();
		HttpStatus status = HttpStatus.OK;
		List<String> carrerasDisponibles = carreraServicio.carrerasDisponibles(corredor);
		if (carrerasDisponibles.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<>(carrerasDisponibles,status);
	}
	
	
	@GetMapping("/consultar/{nombreCarrera}")
	public ResponseEntity<Carrera> consultarCarrera(@PathVariable String nombreCarrera) {
		Optional<Carrera> carrera = carreraServicio.findById(nombreCarrera);
		if (carrera.isPresent()) {
			return new ResponseEntity<>(carrera.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
