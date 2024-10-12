package org.dam2.ejercicioRefuerzo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class NoPerecedero extends Producto {
	
	
	private Enum<Tipos> tipo;
	private String procedencia;
	
	
	
	public NoPerecedero(String numeroReferencia, String nombre, Float precio, int stock, Enum<Tipos> tipo, String procedencia) {
		super(numeroReferencia, nombre, precio, stock);
		this.tipo = tipo;
		this.procedencia = procedencia;

	}
	
	
	
	public NoPerecedero() {
	}



	public Enum<Tipos> getTipo() {
		return tipo;
	}
	public void setTipo(Enum<Tipos> tipo) {
		this.tipo = tipo;
	}
	public String getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	
	public Float getPrecioVenta() {
		if ((this.tipo == Tipos.Belleza || this.tipo == Tipos.Limpieza)&& !this.procedencia.equalsIgnoreCase("espania")) {
			return this.getPrecioCompra() * 2;
		} else {
			return this.getPrecioCompra() + this.getPrecioCompra() * 0.4f;
		}
	}

	@Override
	public String toString() {
		return "NoPerecedero [numeroReferencia=" + getNumeroReferencia() + ", nombre=" + getNombre() + ", precio=" + getPrecioCompra() + ", stock=" + getStock() + ",tipo=" + tipo + ", procedencia=" + procedencia + "]";
	}
	

	public void escribirProducto(ObjectOutputStream out) {
		try {
			out.writeChar('N');
			out.writeUTF(this.getNumeroReferencia());
			out.writeUTF(this.getNombre());
			out.writeFloat(this.getPrecioCompra());
			out.writeInt(this.getStock());
			out.writeUTF(this.tipo.toString());
			out.writeUTF(this.procedencia);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public NoPerecedero leerProducto(ObjectInputStream in) {
		NoPerecedero producto;
		String numeroReferencia = null,nombre = null,paisprocedencia = null;
		Float precio = null;
		int stock = 0;
		Tipos tipo = null;
		try {
			numeroReferencia = in.readUTF();
			nombre = in.readUTF();
			precio = in.readFloat();
			stock = in.readInt();
			String temporal = in.readUTF();
			if (temporal.equalsIgnoreCase("belleza")) {
				tipo = Tipos.Belleza;
			} else if (temporal.equalsIgnoreCase("limpieza")) {
				tipo = Tipos.Limpieza;
			} else {
				tipo = Tipos.Comestible;
			}
			paisprocedencia = in.readUTF();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		producto = new NoPerecedero(numeroReferencia, nombre, precio, stock, tipo, paisprocedencia);
		return producto;

	}
	
}
