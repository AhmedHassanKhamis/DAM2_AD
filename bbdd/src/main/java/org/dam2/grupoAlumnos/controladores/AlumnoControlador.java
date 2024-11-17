package org.dam2.grupoAlumnos.controladores;

import java.time.LocalDate;

import org.dam2.grupoAlumnos.modelo.Alumno;

import daw.com.Teclado;

public class AlumnoControlador implements Controlador<Alumno> {

	private Alumno modelo;
	
	public AlumnoControlador(Alumno modelo) {
		super();
		this.modelo = modelo;
	}

	public Alumno getModelo() {
		return modelo;
	}

	public void setModelo(Alumno modelo) {
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
		modelo.setNombre(Teclado.leerString("Nombre:")); 
		modelo.setFechaNacimiento(LocalDate.parse(Teclado.leerString("Fecha de Nacimiento:"))); 
		modelo.setBeca((Teclado.leerString("Tiene beca(si/no):").equalsIgnoreCase("si"))?true:false); 
	}

	

}
