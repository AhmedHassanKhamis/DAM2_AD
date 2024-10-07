package org.dam2.ejercicioRefuerzo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import daw.com.Teclado;

public class Almacen {

	private Map<Integer, Producto> productos;

	public Almacen(Map<Integer, Producto> productos) {
		super();
		this.productos = productos;
	}

	public Map<Integer, Producto> getProductos() {
		return productos;
	}

	public void setProductos(Map<Integer, Producto> productos) {
		this.productos = productos;
	}

	private void añadirProducto() {
		Producto producto;
		Perecedero productoP;
		NoPerecedero productoNoP;

		int numeroReferencia = Teclado.leerInt("Introduce el numero de referencia:");

		if (!productos.containsKey(numeroReferencia)) {

			String nombre = Teclado.leerString("Introduce el Nombre del producto:");
			int stock = Teclado.leerInt("Introduce el stock en almacen:");
			Float precio = Teclado.leerFloat("Introduce el stock en almacen:");
			producto = new Producto(numeroReferencia, nombre, precio, stock);
			String perecedero = Teclado.leerString("Es un producto perecedero? (S/N):");
			if (perecedero.equalsIgnoreCase("S")) {
				String fechaCaducidadString = Teclado
						.leerString("Introduce la fecha de caducidad con el formato 'dd-mm-aaaa':");
				LocalDate fechaCaducidad = LocalDate.parse(fechaCaducidadString);
				productoP = new Perecedero(numeroReferencia, nombre, precio, stock, fechaCaducidad);
				productos.put(numeroReferencia, productoP);
			} else if (perecedero.equalsIgnoreCase("N")) {
				String tipoString = Teclado.leerString("Introduce el tipo de porducto (Comestible/Limpieza/Belleza):");
				Tipos tipo = null;
				boolean fin = true;
				do {
					switch (tipoString.toLowerCase()) {
						case "comestible":
							tipo = Tipos.Comestible;
							break;
						case "limpieza":
							tipo = Tipos.Limpieza;
							break;
						case "belleza":
							tipo = Tipos.Belleza;
							break;
						default:
							fin = false;
							System.out.println("El dato introducido no se reconoce");
							break;
					} 
				}while (!fin);
				String procedencia = Teclado.leerString("Introduce el pais de procedencia:");
				productos.put(numeroReferencia, new NoPerecedero(numeroReferencia, nombre, precio, stock, tipo, procedencia));

			} else {
				System.out.println("No se reconoce la respuesta ;(");
			}
			System.out.println("Producto agregado con Exito!");
		} else {
			System.out.println("El producto ingresado con el numero de referencia: " + numeroReferencia
					+ " ya ha sido agregado anteriormente");
		}

	}

}