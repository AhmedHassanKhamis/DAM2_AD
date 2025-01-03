package org.dam2.ejercicioRefuerzo2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Deportista {
	
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	
	
	public Deportista() {
		this ("","",LocalDate.now());
	}
	
	
	public Deportista(String dni, String nombre, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		setFechaNacimiento (fechaNacimiento);
	}
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if (fechaNacimiento   != null &&  fechaNacimiento.isBefore(LocalDate.now().minusYears(15)))
			this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public String toString() {
		return "Deportista [dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	public void escribirDeportista(ObjectOutputStream out) {
		try {
			out.writeUTF(getDni());
			out.writeUTF(getNombre());
			out.writeUTF(getFechaNacimiento().toString());	
		} catch (Exception e) {
			System.out.println(e);
		}
	};
	
	public void leerDeportista(ObjectInputStream in) {
		try {
			setDni(in.readUTF());
			setNombre(in.readUTF());
			setFechaNacimiento(LocalDate.parse(in.readUTF()));
		} catch (Exception e) {
			System.out.println(e);
		}
	
	};


	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Deportista other = (Deportista) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
	
	
	

}
