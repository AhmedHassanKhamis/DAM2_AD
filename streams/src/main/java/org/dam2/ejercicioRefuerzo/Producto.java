package org.dam2.ejercicioRefuerzo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

public abstract class Producto {

	private String numeroReferencia;
	private String nombre;
	private Float precio;
	private int stock;
	
	
	
	public Producto(String numeroReferencia, String nombre, Float precio, int stock) {
		super();
		this.numeroReferencia = numeroReferencia;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Producto() {
	}

	public String getNumeroReferencia() {
		return numeroReferencia;
	}
	public void setNumeroReferencia(String numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPrecioCompra() {
		return precio;
	}
	
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock += stock;
	}
	public void reducirStock(int stock) {
		this.stock -= stock;
	}
	
	@Override
	abstract public String toString();
	
	abstract public Float getPrecioVenta();

	@Override
	public int hashCode() {
		return Objects.hash(numeroReferencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Producto other = (Producto) obj;
		return numeroReferencia == other.numeroReferencia;
	}
	
	abstract public void escribirProducto(ObjectOutputStream out);
	
	abstract public Producto leerProducto(ObjectInputStream in);
	
	
}
