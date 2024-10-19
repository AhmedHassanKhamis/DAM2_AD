package org.dam2.ejercicioRefuerzo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import daw.com.Teclado;

public class App {

	private Almacen almacen;

	private App() {
		almacen = new Almacen();
	}

	public static void main(String[] args) {
		App app = new App();
		app.ejecutar();

	}

	private void ejecutar() {
		int opcion;
		cargarProductos();
		do {
			opcion = menu();
			switch (opcion) {
			case 0:
				mostrarProductos();
				break;
			case 1:
				añadirProducto();
				break;
			case 2:
				modificarStockProducto();
				break;
			case 3:
				servirPedido();
				break;
			case 4:
				mostrarPrecios();
				break;
			case 5:
				eliminarCaducados();
				break;
			case 6:
				finalizar();
				break;
			}
		} while (opcion != 6);
	}
	
	
	private int menu() {
		int opcion;
		do {
			System.out.println("---------MENU--------");
			System.out.println("0.mostrar productos");
			System.out.println("1.Añadir producto");
			System.out.println("2.modificar stock producto");
			System.out.println("3.servir pedido");
			System.out.println("4.mostrar precios");
			System.out.println("5.eliminar caducados");
			System.out.println("6.salir");
			opcion = Teclado.leerInt("introduce el numero de una opcion:(0-6)");
			if (opcion < 0 || opcion > 6)
				System.out.println("Opcion incorrecta!!");
		} while (opcion < 0 || opcion > 6);
		return opcion;
	}
	
	
	
	public void cargarProductos() {
		File fichero = new File("productos.dat");
		if (fichero.exists()) {
			ObjectInputStream in = null;
			try {
				in = new ObjectInputStream(new FileInputStream(fichero));
				int cantidad = in.readInt();
				for (int i = 0; i < cantidad; i++) {
					if (in.readChar() == 'P') {
						Perecedero producto = new Perecedero();
						producto = producto.leerProducto(in);
						almacen.getProductos().put(producto.getNumeroReferencia(), producto);
					} else {
						NoPerecedero producto = new NoPerecedero();
						producto = producto.leerProducto(in);
						almacen.getProductos().put(producto.getNumeroReferencia(), producto);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						System.out.println("Error: " + e.getMessage());
						e.printStackTrace();
					}
				}
			}
			
		}		
	}
	
	public void finalizar() {
		File fichero = new File("productos.dat");
		try {
			final ObjectOutputStream  out = new ObjectOutputStream(new FileOutputStream(fichero));
			out.writeInt(almacen.getProductos().size());
			almacen.getProductos().entrySet().stream().forEach(p -> p.getValue().escribirProducto(out));
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("adios!!");
	}
	
	

	private void mostrarProductos() {
		Consumer<? super Entry<String, Producto>> CONSUMIDOR = p -> System.out.println(p.getKey() + "->" + p.getValue());
		if (almacen.getProductos().isEmpty())
			System.out.println("No hay productos!!");
		else
			System.out.println("\n\n-----------PRODUCTOS-----------");
		almacen.getProductos().entrySet().stream().forEach(CONSUMIDOR);
	}

	
	
	private void mostrarPrecios() {
		Map<String, Float> preciosDeVenta = new HashMap<String, Float>();
		for (Map.Entry<String, Producto> entry : almacen.getProductos().entrySet()) {
			preciosDeVenta.put(entry.getKey(), ((Producto) entry.getValue()).getPrecioVenta());
		}
		System.out.println("\n\n-----------PRECIOS DE VENTA-----------");
		preciosDeVenta.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(p -> {
			Producto producto =  almacen.getProductos().get(p.getKey());
			System.out.print("numero referencia->" + producto.getNumeroReferencia());
			System.out.print(", nombre->" + producto.getNombre());
			System.out.println(", precio de venta->" + producto.getPrecioVenta());
		});
	}
	
	private void modificarStockProducto() {
		String numeroReferencia = Teclado.leerString("Introduce el numero de referencia:");
		int cantidad;
		if (almacen.getProductos().containsKey(numeroReferencia)) {
			do {
				cantidad = Teclado.leerInt("Introduce la cantidad a añadir:");
				if(cantidad > 0) {
					almacen.getProductos().get(numeroReferencia).setStock(cantidad);
				}else
					System.out.println("El numero introducido no es valido y/o no puede ser negativo");
			} while (cantidad <= 0);
		}else {
			System.out.println("El producto introducido no existe!");
		}

	}
	
	
	private void eliminarCaducados() {
		Float suma = 0f;
		List<Producto> productosCaducados = almacen.getProductos().values().stream().filter(p -> p instanceof Perecedero).filter(p -> ((Perecedero) p).getFechaCaducidad().isBefore(LocalDate.now())).toList();
		productosCaducados.forEach(p -> almacen.getProductos().remove(p.getNumeroReferencia()));
		suma = productosCaducados.stream().map(Producto::getPrecioCompra).reduce(suma,(p1, p2)-> p1 + p2);
		System.out.println("\n\n-----------PRODUCTOS ELIMINADOS-----------");
		productosCaducados.stream().forEach(p -> {
			System.out.print("numero referencia->" + p.getNumeroReferencia());
			System.out.print(", nombre->" + p.getNombre());
			System.out.println(", stock->" + p.getStock() * p.getPrecioCompra());
		});
		System.out.println("total valor de compra de los caducados: " + suma);
	}
	

	private void añadirProducto() {
		String numeroReferencia = Teclado.leerString("Introduce el numero de referencia:");
		if (almacen.getProductos().isEmpty() || !almacen.getProductos().containsKey(numeroReferencia)) {
			String nombre = Teclado.leerString("Introduce el Nombre del producto:");
			int stock = Teclado.leerInt("Introduce el stock en almacen:");
			Float precio = Teclado.leerFloat("Introduce el Precio de compra:");
			String perecedero = Teclado.leerString("Es un producto perecedero? (S/N):");
			if (perecedero.equalsIgnoreCase("S")) {
				String fechaCaducidadString = Teclado.leerString("Introduce la fecha de caducidad con el formato 'aaaa-mm-aaaa':");
				LocalDate fechaCaducidad = LocalDate.parse(fechaCaducidadString);
				almacen.addProducto(numeroReferencia,new Perecedero(numeroReferencia, nombre, precio, stock, fechaCaducidad));
			} else if (perecedero.equalsIgnoreCase("N")) {
				Tipos tipo = null;
				String tipoString;
				do {
					tipoString = Teclado.leerString("Introduce el tipo de porducto (Comestible/Limpieza/Belleza):");
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
						System.out.println("El dato introducido no se reconoce");
						break;
					}
				} while (!Tipos.tipos().contains(tipo));
				String procedencia = Teclado.leerString("Introduce el pais de procedencia:");
				almacen.addProducto(numeroReferencia,new NoPerecedero(numeroReferencia, nombre, precio, stock, tipo, procedencia));
			} else {
				System.out.println("No se reconoce la respuesta...");
			}
			System.out.println("Producto agregado con Exito!");
		} else {
			System.out.println("El producto ingresado con el numero de referencia: " + numeroReferencia + " ya ha sido agregado anteriormente");
		}

	}
	
	

	private void servirPedido() {
		Map <Producto, Integer> pedidoRealizado = new HashMap<>();
		do {
			String numeroReferencia = Teclado.leerString("Introduce el numero de referencia:");
			if (almacen.getProductos().containsKey(numeroReferencia)) {
				int cantidad = Teclado.leerInt("Introduce la cantidad a servir: (cantidad actual -> "+almacen.getProductos().get(numeroReferencia).getStock()+")");
				if (cantidad < almacen.getProductos().get(numeroReferencia).getStock()) {
					if(pedidoRealizado.containsKey(almacen.getProductos().get(numeroReferencia))) {
						if (cantidad + pedidoRealizado.get(almacen.getProductos().get(numeroReferencia))<= almacen.getProductos().get(numeroReferencia).getStock()) {
							pedidoRealizado.replace(almacen.getProductos().get(numeroReferencia), pedidoRealizado.get(almacen.getProductos().get(numeroReferencia)),pedidoRealizado.get(almacen.getProductos().get(numeroReferencia)) + cantidad);
							System.out.println("producto agregado con exito!");
						}else {
						System.out.println("ERROR:Se agrego en este pedido anteriormente este producto, y con la cantidad intrucida supera el stock actual!!");	
						}
					}else {
						pedidoRealizado.put(almacen.getProductos().get(numeroReferencia), cantidad);
						System.out.println("producto agregado con exito!");
					}
				}else {
					System.out.println("La cantidad introducida es mayor al stock actual:" + almacen.getProductos().get(numeroReferencia).getStock());
				}
			}else {
				System.out.println("El producto no existe en el almacen");
			}
		} while (Teclado.leerString("Desea seguir agregando productos? (S/N)").equalsIgnoreCase("s"));
		System.out.println("########## pedido #############");
		System.out.println("productos---->unidades---->precio unitario---->subtotal");
		for(Map.Entry<Producto, Integer> producto: pedidoRealizado.entrySet()) {
			System.out.println(producto.getKey() + "---->" +producto.getValue()+ "---->" +producto.getKey().getPrecioVenta() + "---->" + ( producto.getKey().getPrecioVenta()*producto.getValue()));
			almacen.getProductos().get(producto.getKey().getNumeroReferencia()).reducirStock(producto.getValue());
		}
		System.out.println("TOTAL: "+ pedidoRealizado.entrySet().stream().mapToDouble(p -> p.getValue() * p.getKey().getPrecioVenta()).sum()); 
	}
	

	

}
