package org.dam2.ejercicioTiempoSevila;

import java.util.Arrays;

public enum Direccion {
	NORTE,SUR,ESTE,OESTE,NORESTE,SURESTE,SUROESTE,NOROESTE,NODESTE,SUDESTE,SUDOESTE,NODOESTE;;

	public static Direccion crearDireccion(String v) {
		// TODO Auto-generated method stub
		return Arrays.stream(Direccion.values()).filter(e -> e.toString().equalsIgnoreCase(v)).findFirst().orElse(Direccion.NORTE);
	}

}
