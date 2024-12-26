package org.dam2.modeloEJ2;

import javax.persistence.PreRemove;


import org.dam2.utilidadeshibernate.GenericJPADAO;

public class ProfesorListener {
	@PreRemove

	private void preRemoveFunction(Profesor a) {
		GenericJPADAO <Estudiante, Integer> estudianteDAO = new GenericJPADAO(Estudiante.class, "hibernate"); ;
		
		String query = "UPDATE Estudiante SET nifProfesor = ?1 where nifProfesor = ?2";
		estudianteDAO.executeQuery(query, null, a.getNif());
	}
}
