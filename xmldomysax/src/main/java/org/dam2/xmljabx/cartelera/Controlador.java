package org.dam2.xmljabx.cartelera;

public interface Controlador <T> {
	
	public default void leerDatos (T pojo)
	{
		leerClave (pojo);
		leerOtrosDatos(pojo);
	}
	
	public void leerClave (T pojo);
	public void leerOtrosDatos (T pojo);

}
