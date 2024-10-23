package org.dam2.xmljabxejemplo;

public interface Controlador <T> {
	
	public default void leerDatos (T pojo)
	{
		leerClave (pojo);
		leerOtrosDatos(pojo);
	}
	
	public void leerClave (T pojo);
	public void leerOtrosDatos (T pojo);

}