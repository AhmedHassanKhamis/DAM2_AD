package org.dam2.ejercicioRefuerzo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Perecedero extends Producto {

	private LocalDate fechaCaducidad;

	public Perecedero(String numeroReferencia, String nombre, Float precio, int stock, LocalDate fechaCaducidad) {
		super(numeroReferencia, nombre, precio, stock);
		this.fechaCaducidad = fechaCaducidad;
	}
	

	public Perecedero() {
	}


	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Float getPrecioVenta() {
		long dias = ChronoUnit.DAYS.between(LocalDate.now(), this.fechaCaducidad);

		if (dias > 5) {
			return this.getPrecioCompra() * 2;
		} else if (3 <= dias && dias <= 5) {
			return this.getPrecioCompra() + this.getPrecioCompra() / 2;
		} else if (0 < dias && dias < 3) {
			return this.getPrecioCompra();
		} else {
			return 0f;
		}
	}

	@Override
	public String toString() {
		return "Perecedero [numeroReferencia=" + getNumeroReferencia() + ", nombre=" + getNombre() + ", precio="
				+ getPrecioCompra() + ", stock=" + getStock() + ", fechaCaducidad=" + fechaCaducidad + "]";
	}

	public void escribirProducto(ObjectOutputStream out) {
		try {
			out.writeChar('P');
			out.writeUTF(this.getNumeroReferencia());
			out.writeUTF(this.getNombre());
			out.writeFloat(this.getPrecioCompra());
			out.writeInt(this.getStock());
			out.writeUTF(this.fechaCaducidad.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Perecedero leerProducto(ObjectInputStream in) {
		Perecedero producto;
		String numeroReferencia = null,nombre = null;
		Float precio = null;
		int stock = 0;
		LocalDate fechaCaducidad = null;
		try {
			numeroReferencia = in.readUTF();
			nombre = in.readUTF();
			precio = in.readFloat();
			stock = in.readInt();
			fechaCaducidad = LocalDate.parse(in.readUTF());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		producto = new Perecedero(numeroReferencia, nombre, precio, stock, fechaCaducidad);
		return producto;

	}

}
