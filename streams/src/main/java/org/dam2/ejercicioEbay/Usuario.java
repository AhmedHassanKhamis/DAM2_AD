package org.dam2.ejercicioEbay;

import java.util.function.Function;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@AllArgsConstructor
@Data
@Builder
@Setter(value = AccessLevel.NONE )
public class Usuario {
	private final int MINIMO = 50;
	private final String nombre;
	private int credito;
	
	
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.credito = MINIMO;
	}
	
	
	public void incrementarCredito(int nuevo) {
		if(nuevo > 0)
			this.credito += nuevo;
	}
	
	public void decrementarCredito(int nuevo) {
		if(nuevo < 0)
			this.credito -= nuevo;
	}
	
	
	
}
