package org.dam2.opencsv;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

public class Grupo {
	
	@CsvBindByPosition(position = 0)
	private String nombre;
	@CsvBindAndSplitByPosition(position = 1, elementType= Alumno.class, splitOn = ",", converter = TextToAlumno.class)
	private List<Alumno> alumnos;
	
	public Grupo(String nombre, List<Alumno> alumnos) {
		super();
		this.nombre = nombre;
		this.alumnos = alumnos;
	}
	
	public Grupo ()
	{
		this ("", new ArrayList<>());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", alumnos=" + alumnos + "]";
	}
	
	

}
