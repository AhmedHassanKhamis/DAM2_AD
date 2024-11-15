package org.dam2.grupoyalumnos.controladores;

import org.dam2.grupoyalumnos.modelo.Alumno;

import daw.com.Teclado;

public class AlumnoControlador implements Controlador<Alumno> {

	private Alumno modelo;
	
	public AlumnoControlador(Alumno modelo) {
		super();
		this.modelo = modelo;
	}

	@Override
	public void leerClave() {
		// TODO Auto-generated method stub
		modelo.setNia (Teclado.leerString("nia"));
	}

	@Override
	public void leerRestoDatos() {
		// TODO Auto-generated method stub
		
	}

	public Alumno getModelo() {
		return modelo;
	}

	public void setModelo(Alumno modelo) {
		this.modelo = modelo;
	}

	

}
