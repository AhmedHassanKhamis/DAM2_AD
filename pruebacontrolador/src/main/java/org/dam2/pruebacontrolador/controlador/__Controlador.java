package org.dam2.pruebacontrolador.controlador;

import java.time.LocalDate;
import java.util.Random;

import org.dam2.pruebacontrolador.modelo.__Material;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.PostPersist;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/prueba")
public class __Controlador {
	int nVisitas;

	public __Controlador() {
		nVisitas = 0;
		System.out.println("SOY EL CONSTRUTOR MAAAAM");
	}

	@GetMapping("/saluda")
	public ResponseEntity<String> saludaAlPublico() {
		ResponseEntity<String> respuesta;

		String mensaje = "hola mundo, hilo de ejecucion: ";
		Random r = new Random();
		mensaje += Thread.currentThread().getName();
		nVisitas++;
		mensaje += " nvisitas: " + nVisitas;

		try {
			Thread.currentThread().sleep(r.nextInt(10000) + 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		respuesta = new ResponseEntity<String>(mensaje, HttpStatus.OK);

		return respuesta;

	}
//	@GetMapping("/buscarMaterial/{id}")
//	public ResponseEntity<Material> findMaterial(@PathVariable String id) {
	@GetMapping("/buscarMaterial")
	public ResponseEntity<__Material> findMaterial(@RequestParam String id) {
		ResponseEntity<__Material> respuesta;
		__Material m;
		if (id.equals("01")) {
			m = __Material.builder().director("ahmed").fechaEstreno(LocalDate.of(2002, 2, 10)).nombre("Batman")
					.referencia("01").build();

			respuesta = new ResponseEntity<__Material>(m, HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<__Material>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
	}

	@PostMapping("/subirMaterial")
	public ResponseEntity<__Material> postMaterial(@RequestBody __Material m) {
		ResponseEntity<__Material> respuesta;
		m.setNombre("peter");
		respuesta = new ResponseEntity<__Material>(m, HttpStatus.OK);
		return respuesta;
	}

}
