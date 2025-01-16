package org.dam2.modelo;

import javax.persistence.PreRemove;

public class ProfesorListener {
	
	@PreRemove
	private void preRemoveFunction(Profesor p) {
		System.out.println("hola");
	}

}
