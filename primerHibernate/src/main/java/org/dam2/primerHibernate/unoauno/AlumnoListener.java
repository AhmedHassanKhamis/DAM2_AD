package org.dam2.unoauno;

import javax.persistence.PrePersist;

public class AlumnoListener {
	   // Se ejecuta antes de persistir la entidad para igualar las claves

	   
	  //  @PreUpdate
	  @PrePersist
	
	    private void prePersistFunction(Alumno a)
	    {
	    	System.out.println("antes de merge");
	    	
	    	System.out.println(a.getDireccion());
	    }
	   
}