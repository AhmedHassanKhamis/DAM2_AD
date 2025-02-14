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

import com.dam2.examenspring.modelo.Usuario;
import com.dam2.examenspring.servicio.IUsuarioServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControladorRest {

	@Autowired
	IUsuarioServicio usuarioServicio;

	@PostMapping("/consultar")
	public ResponseEntity<Usuario> comprobarUsuario(@RequestBody Usuario usuario) {
		Optional<Usuario> usuarioExiste = usuarioServicio.buscarPorNombreContrasenia(usuario);

		if (usuarioExiste.isPresent()) {
			return new ResponseEntity<>(usuarioExiste.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/registrar")
	public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
		Optional<Usuario> usuarioExiste = usuarioServicio.buscarPorNombreContrasenia(usuario);
		if (usuarioExiste.isEmpty()) {
			if (usuario.getFechaNacimiento().isBefore(LocalDate.now().minusYears(18))) {
				if (usuarioServicio.insert(usuario)) {
					return new ResponseEntity<>(usuario, HttpStatus.OK);
				}else {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
