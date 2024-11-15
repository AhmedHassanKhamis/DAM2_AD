package org.dam2.grupoyalumnos;

import org.dam2.grupoyalumnos.controladores.AlumnoControlador;
import org.dam2.grupoyalumnos.dao.AlumnoDAO;
import org.dam2.grupoyalumnos.modelo.Alumno;
import org.dam2.grupoyalumnos.vistas.AlumnoVista;
import org.dam2.grupoyalumnos.vistas.Vista;

public class AppGrupos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Leer y mostrar un alumno
		Alumno alumno = new Alumno ();
		AlumnoControlador alumnoControlador;
		Vista alumnoVista;
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		
		alumnoControlador = new AlumnoControlador (alumno);
		alumnoControlador.leerDatos();
		
		alumnoDAO.findById("001").
				ifPresentOrElse(null, null);
		
		alumnoVista = new AlumnoVista(alumno);
		alumnoVista.mostrarModelo();
		
		
	}

}
