package org.dam2.grupoyalumnos.controladores;

import org.dam2.grupoyalumnos.modelo.Grupo;

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
		
	}

	@Override
	public void leerRestoDatos() {
		// TODO Auto-generated method stub
		
	}
	
	
}
