package org.dam2.opencsv;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;



public class Alumno 
{
	private static final String SEPARADOR = ":";
	@CsvBindByPosition(position = 0)
	private String dni;
	@CsvBindByPosition(position = 1)
	private String nombre;
	@CsvBindByPosition(position = 2)
	@CsvDate("yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@CsvBindByPosition(position = 3)
	private int nota;
	
	public Alumno ()
	{
		this("");
	}
	
	public Alumno (String dni)
	{
		this(dni, "",LocalDate.now().minusYears(18), 1);
	}
	public Alumno(String dni, String nombre, LocalDate fechaNacimiento, int nota) throws IllegalArgumentException
	{
		
		this.dni = dni;
		this.nombre = nombre;
		setFechaNacimiento (fechaNacimiento);
		setNota (nota);
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

	public void setFechaNacimiento(LocalDate fechaNacimiento) throws IllegalArgumentException {
		
		if (fechaNacimiento == null)
			throw new IllegalArgumentException("alumno sin datos de fecha de nacimiento");
		if (fechaNacimiento.plusYears(18).isAfter(LocalDate.now()))
			throw new IllegalArgumentException("alumno menor de edad");
		
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) throws IllegalArgumentException{
		if (nota < 1 || nota > 10)
			throw new IllegalArgumentException("nota no permitida");
		
			
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", nota=" + nota
				+ "]";
	}
	

}