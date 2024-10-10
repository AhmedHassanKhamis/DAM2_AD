package org.dam2.ejercicioRefuerzo;

import java.util.Map;
import java.util.function.Consumer;

import daw.com.Teclado;

public class App {
	
	public static void main(String[] args) {
		App app = new App();
		App.ejecutar();
		
	}
	
	public static int menu() {
		System.out.println("-----------------");
		System.out.println("1.Añadir producto");
		System.out.println("2.modificar stock producto");
		System.out.println("3.servir pedido");
		System.out.println("4.mostrar precios");
		System.out.println("5.eliminar caducados");
		System.out.println("6.salir");
		return Teclado.leerInt("introduce un opcion:");
	}
	
	public static void ejecutar() {
		int opcion = 0;
		Almacen almacen = new Almacen();
		almacen.cargarProductos();
		Consumer<Map.Entry<Integer,Producto>> CONSUMIDOR = p -> System.out.println(p.getKey() + "->" + p.getValue());
		do {
			System.out.println("PRODUCTOS--------------------------------");
			almacen.getProductos().entrySet().stream().forEach(CONSUMIDOR);
			opcion = menu();
			switch (opcion) {
			case 1:
				almacen.añadirProducto();;
				break;
			case 2:
				almacen.modificarStockProducto();
				break;
			case 3:
				almacen.servirPedido();
				break;
			case 4:
				almacen.mostrarPrecios();
				break;
			case 5:
				almacen.eliminarCaducados();
				break;
			case 6:
				almacen.finalizar();
				break;

			default:
				System.out.println("Opcion incorrecta!!");
				break;
			}
		} while (opcion != 6);
	}

}
