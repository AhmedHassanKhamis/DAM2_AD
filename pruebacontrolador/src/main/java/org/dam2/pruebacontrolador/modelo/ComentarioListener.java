package org.dam2.pruebacontrolador.modelo;

import jakarta.persistence.PrePersist;

public class ComentarioListener {

	@PrePersist
	public void prePersistFunction(Comentario c) {
		if (c.getValoracion() > 5) {
			c.setValoracion(5);
		}
		if (c.getValoracion() < 1) {
			c.setValoracion(1);
		}
	}
	
}
