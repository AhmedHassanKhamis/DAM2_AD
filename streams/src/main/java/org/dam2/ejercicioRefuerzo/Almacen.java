package org.dam2.ejercicioRefuerzo;

import java.time.LocalDate;
import java.util.ArrayList;
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
	
	
	private void mostrarPrecios() {
		productos.;
	}
	
	
	private void servirPedido() {
		boolean seguir;
		List<Integer> unidades = new ArrayList<Integer>();
		List<Producto> pedido = new ArrayList<Producto>();
		
		do {
			int numeroReferencia = Teclado.leerInt("Introduce el numero de referencia:");
			if (productos.containsKey(numeroReferencia)) {
				int cantidad = Teclado.leerInt("Introduce la cantidad a servir: (cantidad actual -> "+productos.get(numeroReferencia).getStock()+")");
				if (cantidad < productos.get(numeroReferencia).getStock()) {
					if(pedido.contains(productos.get(numeroReferencia))) {
						int posicion = pedido.indexOf(productos.get(numeroReferencia));
						if (unidades.get(posicion) + cantidad <= productos.get(numeroReferencia).getStock()) {
							unidades.set(posicion, unidades.get(posicion) + cantidad);	
							System.out.println("producto agregado con exito!");
						}else {
						System.out.println("ERROR:Se agrego en este pedido anteriormente este producto, y con la cantidad intrucida supera el stock actual!!");	
						}
					}else {
						unidades.add(cantidad);
						pedido.add(productos.get(numeroReferencia));
						System.out.println("producto agregado con exito!");
					}
				}else {
					System.out.println("La cantidad introducida es mayor al stock actual:" + productos.get(numeroReferencia).getStock());
				}
			
			}else {
				System.out.println("El producto no existe en el almacen");
			}
			
			if(Teclado.leerString("Desea seguir agregando productos? (S/N)").equalsIgnoreCase("s")) {
				seguir = true;
			}else {
				seguir = false;
			}
		} while (seguir = true);
		System.out.println("########## pedido #############");
		System.out.println("productos---->unidades");
		for(int i=0;i < pedido.size();i++) {
			System.out.println(pedido.get(i) + "---->" +unidades.get(i) + "---->" + (pedido.get(i).getPrecioVenta()*unidades.get(i)));
			productos.get(pedido.get(i)).setStock(-unidades.get(i));
		}
		System.out.println("TOTAL: "+ unidades.stream().mapToDouble(u -> u * pedido.get(unidades.indexOf(u)).getPrecioVenta()).sum()); 
	}
	
	
	private void modificarStockProducto() {
		int numeroReferencia = Teclado.leerInt("Introduce el numero de referencia:");
		int cantidad;
		
		
		if (productos.containsKey(numeroReferencia)) {
			do {
				cantidad = Teclado.leerInt("Introduce la cantidad a añadir:");
				if(cantidad >= 0)
					productos.get(numeroReferencia).setStock(cantidad);
				else
					System.out.println("El numero introducido no es valido y/o no puede ser negativo");
			} while (cantidad <= 0);
		}else {
			System.out.println("El producto introducido no existe!");
		}
		
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
