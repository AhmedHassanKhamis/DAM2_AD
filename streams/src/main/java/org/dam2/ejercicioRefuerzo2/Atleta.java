package org.dam2.ejercicioRefuerzo2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;

public class Atleta extends Deportista{

	
	private String lugarPrueba;
	private float metros;
	private LocalTime marca;
	
	
	public Atleta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Atleta(String dni, String nombre, LocalDate fechaNacimiento, String lugarPrueba, float metros, LocalTime marca) {
		super(dni, nombre, fechaNacimiento);
		this.lugarPrueba = lugarPrueba;
		this.metros = metros;
		this.marca = marca;
		// TODO Auto-generated constructor stub
	}
	public String getLugarPrueba() {
		return lugarPrueba;
	}
	public void setLugarPrueba(String lugarPrueba) {
		this.lugarPrueba = lugarPrueba;
	}
	public float getMetros() {
		return metros;
	}
	public void setMetros(float metros) {
		this.metros = metros;
	}
	public LocalTime getMarca() {
		return marca;
	}
	public void setMarca(LocalTime marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Atleta [dni=" + getDni() + ", nombre=" + getNombre() + ", fechaNacimiento=" + getFechaNacimiento() + ", lugarPrueba=" + lugarPrueba + ", metros=" + metros + ", marca=" + marca + "]";
	}

	@Override
	public void escribirDeportista (ObjectOutputStream out) {
		// TODO Auto-generated method stub
		try {
			out.writeChar('A');
			out.writeUTF(getDni());
			out.writeUTF(getNombre());
			out.writeUTF(getFechaNacimiento().toString());
			out.writeUTF(lugarPrueba);
			out.writeFloat(metros);
			out.writeUTF(marca.toString());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}


	@Override
	public Deportista leerDeportista(ObjectInputStream in) {
		// TODO Auto-generated method stub
		String dni = null, nombre = null, lugarPrueba = null;
		LocalDate fechaNacimiento = null;
		LocalTime marca = null;
		float metros = 0;
		try {
			dni = in.readUTF();
			nombre = in.readUTF();
			fechaNacimiento = LocalDate.parse(in.readUTF());
			lugarPrueba = in.readUTF();
			metros = in.readFloat();
			marca = LocalTime.parse(in.readUTF());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return new Atleta(dni, nombre, fechaNacimiento, lugarPrueba, metros, marca);
	}
	
	
	
	
	
	
	
	
	
}
