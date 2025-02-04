package org.dam2.pruebacontrolador.modelo;


import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class UsuarioListener {
	@PrePersist
	@PreUpdate
	private void prePersistFunction(Usuario u) {
		if (true) {
			
		}
	}
	
}
