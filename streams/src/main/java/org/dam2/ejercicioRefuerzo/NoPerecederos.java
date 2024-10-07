package org.dam2.ejercicioRefuerzo;

public class NoPerecederos extends Producto {
	
	
	private Enum<Tipos> tipo;
	private String procedencia;
	
	
	
	public NoPerecederos(int numeroReferencia, String nombre, Float precio, int stock, Enum<Tipos> tipo, String procedencia) {
		super(numeroReferencia, nombre, precio, stock);
		this.tipo = tipo;
		this.procedencia = procedencia;

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
	
	

}
