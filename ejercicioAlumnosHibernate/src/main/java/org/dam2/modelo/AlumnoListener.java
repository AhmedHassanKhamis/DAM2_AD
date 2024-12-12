package org.dam2.modelo;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AlumnoListener {
	
	@PreRemove

	private void preRemoveFunction(Alumno a) {
		GenericJPADAO <Calificacion, Integer> calificacionDAO = new GenericJPADAO(Calificacion.class, "hibernate"); ;
		
		String query = "DELETE FROM Calificacion c WHERE c.alumno.dni = ?1";
		calificacionDAO.executeQuery(query, a.getDni());
	}
}
