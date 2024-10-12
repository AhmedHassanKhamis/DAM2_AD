package org.dam2.ejercicioRefuerzo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Almacen {

	private HashMap<String, Producto> productos;

	public Almacen(HashMap<String, Producto> productos) {
		super();
		this.productos = productos;
	}


	public Almacen() {
		this.productos = new HashMap<>();
	}
	
	public HashMap<String, Producto> getProductos() {
		return productos;
	}

	public void setProductos(HashMap<String, Producto> productos) {
		this.productos = productos;
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
						productos.put(producto.getNumeroReferencia(), producto);
					} else {
						NoPerecedero producto = new NoPerecedero();
						producto = producto.leerProducto(in);
						productos.put(producto.getNumeroReferencia(), producto);
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
			out.writeInt(productos.size());
			productos.entrySet().stream().forEach(p -> p.getValue().escribirProducto(out));
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
	
	public void addProducto(String numeroReferencia, Perecedero producto) {
		productos.put(numeroReferencia,producto);
	}

	public void addProducto(String numeroReferencia, NoPerecedero producto) {
		productos.put(numeroReferencia,producto);
	}

}
