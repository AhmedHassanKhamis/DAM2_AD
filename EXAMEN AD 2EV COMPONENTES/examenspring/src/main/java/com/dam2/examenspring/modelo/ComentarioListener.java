package com.dam2.examenspring.modelo;

import jakarta.persistence.PrePersist;

public class ComentarioListener {
	
	@PrePersist
	public void prePersistFunction(Comentario comentario) {
		if (comentario.getValoracion() > 5) {
			comentario.setValoracion(5);
		}else if(comentario.getValoracion() < 1) {
			comentario.setValoracion(1);
		}
	}
	
}
