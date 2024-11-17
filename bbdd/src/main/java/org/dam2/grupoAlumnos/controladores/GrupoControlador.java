package org.dam2.grupoAlumnos.controladores;

import org.dam2.grupoAlumnos.modelo.Grupo;

import daw.com.Teclado;

public class GrupoControlador implements Controlador<Grupo> {
	private Grupo modelo;

	public GrupoControlador(Grupo modelo) {
		super();
		this.modelo = modelo;
	}

	public Grupo getModelo() {
		return modelo;
	}

	public void setModelo(Grupo modelo) {
		this.modelo = modelo;
	}

	@Override
	public void leerClave() {
		// TODO Auto-generated method stub
		modelo.setNombre(Teclado.leerString("Nombre:"));

		
	}

	@Override
	public void leerRestoDatos() {
		// TODO Auto-generated method stub
		modelo.setTutor(Teclado.leerString("Tutor:"));
		modelo.setCurso(Teclado.leerInt("Curso:"));

	}
	
	
	
	
}
