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

	
	public void addProducto(String numeroReferencia, Perecedero producto) {
		productos.put(numeroReferencia,producto);
	}

	public void addProducto(String numeroReferencia, NoPerecedero producto) {
		productos.put(numeroReferencia,producto);
	}

}
