package org.dam2.ejercicioCorredores.controlador;
import java.util.List;
import java.util.Optional;

import org.dam2.ejercicioCorredores.modelo.Corredor;
import org.dam2.ejercicioCorredores.modelo.CorredorCarrera;
import org.dam2.ejercicioCorredores.servicio.ICarreraServicio;
import org.dam2.ejercicioCorredores.servicio.ICorredorCarreraServicio;
import org.dam2.ejercicioCorredores.servicio.ICorredorServicio;
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
@RequestMapping("/inscripcion")
public class CorredorCarreraControladorRest {
	
	@Autowired ICarreraServicio carreraServicio;
	@Autowired ICorredorCarreraServicio corredorCarreraServicio;
	@Autowired ICorredorServicio corredorServicio;
	
	@PostMapping("/inscribir")
	public ResponseEntity<CorredorCarrera> inscribir(@RequestBody CorredorCarrera inscripcion){
		HttpStatus status = HttpStatus.CREATED;
		try {
			if (corredorCarreraServicio.buscarInscripcion(inscripcion).isEmpty()) {
				if (!corredorServicio.findById(inscripcion.getCorredor().getDni()).isPresent()) {
					corredorServicio.insert(inscripcion.getCorredor());
				}
				if (carreraServicio.findById(inscripcion.getCarrera().getNombreCarrera()).isPresent()) {
					if (!corredorCarreraServicio.insert(inscripcion))
						status = HttpStatus.BAD_REQUEST;
				} else {
					status = HttpStatus.NOT_FOUND;
				}
			}else {
				status = HttpStatus.FORBIDDEN;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(inscripcion,status);
	}
	
	@PostMapping("/anotarTiempo")
	public ResponseEntity<String> anotarTiempos(@RequestBody CorredorCarrera inscripcion){
		HttpStatus status = HttpStatus.CREATED;
		String resultado = "FALLO AL ANOTAR TIEMPO";
		
		try {
			if (corredorCarreraServicio.buscarInscripcion(inscripcion).isPresent()) {
				if (!corredorCarreraServicio.insert(inscripcion)) {
					status = HttpStatus.BAD_REQUEST;
				}else {
					resultado = "TIEMPO ANOTADO CON EXITO";
				}
					
				
			} else {
				status = HttpStatus.NOT_FOUND;
				resultado = "EL CORREDOR NO ESTA INSCRITO EN LA CARRERA";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(resultado,status);
	}
	
	
	
	@GetMapping("/tiempos/{nombreCarrera}")
	public ResponseEntity<List<CorredorCarrera>> sacarInscripcionesPorCarrera(@PathVariable String nombreCarrera) {
		List<CorredorCarrera> inscripciones = corredorCarreraServicio.participacionesCarrera(nombreCarrera);
		if (!inscripciones.isEmpty()) {
			return new ResponseEntity<>(inscripciones,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/consultar")
	public ResponseEntity<CorredorCarrera> consultarInscripcion(@RequestBody CorredorCarrera inscripcion){
		Optional<CorredorCarrera> inscripcionEncontrada = corredorCarreraServicio.buscarInscripcion(inscripcion);
		if (inscripcionEncontrada.isPresent()) {
			return new ResponseEntity<>(inscripcionEncontrada.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping("/listarOrdenLlegadaCarreraMasAntigua")
	public ResponseEntity<List<String>> listarPorOrdenLlegadaAntigua(){
		List<String> resultados = corredorCarreraServicio.listarPorOrdenLlegada();
		
		if (!resultados.isEmpty()) {
			return new ResponseEntity<>(resultados,HttpStatus.OK);
		} else {
			return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		}
		
	}

}
