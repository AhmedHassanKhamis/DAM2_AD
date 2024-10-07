package org.dam2.ejercicioRefuerzo;

public class Producto {

	private int numeroReferencia;
	private String nombre;
	private Float precio;
	private int stock;
	
	
	
	public Producto(int numeroReferencia, String nombre, Float precio, int stock) {
		super();
		this.numeroReferencia = numeroReferencia;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	
	public int getNumeroReferencia() {
		return numeroReferencia;
	}
	public void setNumeroReferencia(int numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Producto [numeroReferencia=" + numeroReferencia + ", nombre=" + nombre + ", precio=" + precio
				+ ", stock=" + stock + "]";
	}
	
	
}
