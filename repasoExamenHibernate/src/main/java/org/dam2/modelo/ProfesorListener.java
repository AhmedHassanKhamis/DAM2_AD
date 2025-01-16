package org.dam2.modelo;

import javax.persistence.PreRemove;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class ProfesorListener {
	
	@PreRemove
	private void preRemoveFunction(Profesor p) {
		GenericJPADAO<Persona, Long> personaDAO  = new GenericJPADAO(Persona.class,"hibernate");
////		String query = "UPDATE E FROM PROFESOR P LEFT JOIN P.TUTORADOS E SET E.NIF_TUTOR = NULL WHERE ";
//		String query = "UPDATE Profesor p SET p.tutorados = NULL WHERE p = ?1";
//		personaDAO.executeQuery(query, p);
		p.setTutorados(null);
		personaDAO.update(p);
		
		 
		 
		
	}

}
