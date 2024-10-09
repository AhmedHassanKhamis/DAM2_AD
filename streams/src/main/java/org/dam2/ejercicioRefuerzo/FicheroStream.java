package org.dam2.ejercicioRefuerzo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FicheroStream {
	HashMap<Integer, Producto> productos;

	public FicheroStream() {
		this.productos = new HashMap<Integer, Producto>();
	}

	public void escribirFichero(Map<Integer, Producto> productos, File fichero) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(fichero));
			out.writeInt(productos.size());
			for (Producto producto : productos.values()) {
				if (producto instanceof Perecedero) {
					Perecedero perecedero = (Perecedero) producto;
					out.writeChar('P');
					out.writeInt(perecedero.getNumeroReferencia());
					out.writeUTF(perecedero.getNombre());
					out.writeFloat(perecedero.getPrecioCompra());
					out.writeInt(perecedero.getStock());
					out.writeUTF(perecedero.getFechaCaducidad().toString());
				} else {
					NoPerecedero noPerecedor = (NoPerecedero) producto;
					out.writeChar('N');
					out.writeInt(noPerecedor.getNumeroReferencia());
					out.writeUTF(noPerecedor.getNombre());
					out.writeFloat(noPerecedor.getPrecioCompra());
					out.writeInt(noPerecedor.getStock());
					if (noPerecedor.getTipo().equals(Tipos.Belleza)) {
						out.writeUTF("belleza");
					} else if (noPerecedor.getTipo().equals(Tipos.Limpieza)) {
						out.writeUTF("limpieza");
					} else {
						out.writeUTF("comestible");
					}
					out.writeUTF(noPerecedor.getProcedencia());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public HashMap<Integer, Producto> leerFichero(File fichero) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fichero));
			int cantidad = in.readInt();
			for (int i = 0; i < cantidad; i++) {
				if (in.readChar() == 'P') {
					int numeroreferencia = in.readInt();
					String nombre = in.readUTF();
					Float precio = in.readFloat();
					int stock = in.readInt();
					LocalDate fechacaducidad = LocalDate.parse(in.readUTF());
					productos.put(numeroreferencia,new Perecedero(numeroreferencia, nombre, precio, stock, fechacaducidad));
				} else {
					int numeroreferencia = in.readInt();
					String nombre = in.readUTF();
					Float precio = in.readFloat();
					int stock = in.readInt();
					String temporal = in.readUTF();
					Tipos tipo;
					if (temporal.equalsIgnoreCase("belleza")) {
						tipo = Tipos.Belleza;
					} else if (temporal.equalsIgnoreCase("limpieza")) {
						tipo = Tipos.Limpieza;
					} else {
						tipo = Tipos.Comestible;
					}
					String paisprocedencia = in.readUTF();
					productos.put(numeroreferencia,new NoPerecedero(numeroreferencia, nombre, precio, stock, tipo, paisprocedencia));
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
		return productos;

	}

	public Map<Integer, Producto> getProductos() {
		return productos;
	}

}