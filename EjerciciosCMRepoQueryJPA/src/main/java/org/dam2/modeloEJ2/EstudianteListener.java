package org.dam2.modeloEJ2;

import javax.persistence.PrePersist;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class EstudianteListener {
	
	@PrePersist
	
	private void prePersistFunction(Estudiante e) {
		GenericJPADAO <Estudiante, Integer> estudianteDAO = new GenericJPADAO(Estudiante.class, "hibernate"); ;
		String query = "SELECT count(e) from Estudiante e where nifProfesor = ?1";
		int cuantos = (int) estudianteDAO.executeQuerySingleResult(query, e.getTutor().getNif()).orElse(0);
		if (cuantos >= 10 ) {
			e.setTutor(null);
		}
	}
}
