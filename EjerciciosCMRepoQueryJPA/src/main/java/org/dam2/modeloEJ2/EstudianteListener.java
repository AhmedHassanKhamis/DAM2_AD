package org.dam2.modeloEJ2;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class EstudianteListener {
	
	@PostPersist
	
	private void postPersistFunction(Estudiante e) {
		GenericJPADAO <Persona, Integer> personaDAO = new GenericJPADAO(Persona.class, "hibernate"); ;
		String query = "SELECT count(e.tutor) from Estudiante e where tutor = ?1";
		Long cuantos = (Long) personaDAO.executeQuerySingleResult(query, e.getTutor()).get();
//		System.out.println(cuantos);
 		if (cuantos > 10 ) {
			e.setTutor(null);
		}
	}
}
