package org.dam2.grupoyalumnos.vistas;

public abstract class Vista <T>{
	private T modelo;

	public Vista(T modelo) {
		super();
		this.modelo = modelo;
	}

	public T getModelo() {
		return modelo;
	}

	public void setModelo(T modelo) {
		this.modelo = modelo;
	}
	
	public void mostrarModelo ()
	{
		System.out.println(modelo);
	}

}
