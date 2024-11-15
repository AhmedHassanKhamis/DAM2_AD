package org.dam2.grupoyalumnos.controladores;

public interface Controlador<T> {

	public void leerClave ();
	public void leerRestoDatos ();
	public void setModelo (T modelo);
	public T getModelo ();
	
	public default void leerDatos ()
	{
		leerClave ();
		leerRestoDatos ();
	}
}
