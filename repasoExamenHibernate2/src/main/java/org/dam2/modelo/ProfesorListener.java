package org.dam2.modelo;

import javax.persistence.PreRemove;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class ProfesorListener {

	@PreRemove
	public void preRemoveFunction(Profesor p) {
		GenericJPADAO<Persona, String>personaDAO = new GenericJPADAO<Persona, String>(Persona.class, "hibernate");
		String query = "UPDATE Estudiante e set tutor = null where tutor = ?1";
		personaDAO.executeQuery(query, p);

	}
}
