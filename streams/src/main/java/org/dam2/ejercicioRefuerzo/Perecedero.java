package org.dam2.ejercicioRefuerzo;

import java.time.LocalDate;

public class Perecedero extends Producto{


	private LocalDate fechaCaducidad;

	
	
	public Perecedero(int numeroReferencia, String nombre, Float precio, int stock, LocalDate fechaCaducidad) {
		super(numeroReferencia, nombre, precio, stock);
		this.fechaCaducidad = fechaCaducidad;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	
	
}
