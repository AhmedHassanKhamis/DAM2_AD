package org.dam2.modelo;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class CalificacionListener {
	// Se ejecuta antes de persistir la entidad para igualar las claves

	@PreUpdate
	@PrePersist

	private void prePersistFunction(Calificacion c) {
		if (c.getNota() > 10) {
			c.setNota(10);
		}else if(c.getNota() < 1) {
			c.setNota(1);
		}

	}
}
