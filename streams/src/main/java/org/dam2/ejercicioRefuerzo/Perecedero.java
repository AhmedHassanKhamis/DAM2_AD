package org.dam2.ejercicioRefuerzo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


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
	
	
	public Float getPrecioVenta() {
		long dias = ChronoUnit.DAYS.between(LocalDate.now(),this.fechaCaducidad);
		
		if (dias > 5) {
			return this.getPrecioCompra() * 2; 
		}else if (3 <= dias && dias <= 5) {
			return this.getPrecioCompra() + this.getPrecioCompra()/2;
		}else if (0 < dias && dias < 3){
			return this.getPrecioCompra();
		}else {
			return 0f;
		}
	}
}
