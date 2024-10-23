package org.dam2.ejercicioTiempoSevila;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import daw.com.Teclado;


public class ControladorPeliculaConsola implements Controlador<Tiempo> {

	@Override
	public void leerClave(Tiempo pojo) {
		// TODO Auto-generated method stub
		String codigo = Teclado.leerString("Codigo:");
		pojo.setCodigo(codigo);
	}

	@Override
	public void leerOtrosDatos(Tiempo pojo) {
		// TODO Auto-generated method stub
		pojo.setDuracion(Teclado.leerInt("Duracion:"));
		pojo.setFecha(LocalDate.parse(Teclado.leerString("Fecha:"),DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		pojo.setTitulo(Teclado.leerString("Titulo:"));
//		pojo.setTituloOriginal(Teclado.leerString("Titulo original:"));
		pojo.setTituloOriginal(Teclado.leerString("Desea agregar un titulo original?").equalsIgnoreCase("S")? 
				Teclado.leerString("Titulo original:")  
				:null);
		pojo.setNacionalidad(Teclado.leerString("Nacionalidad:"));
		pojo.setGenero(Teclado.leerString("Genero:"));
		pojo.setClasificacion(Teclado.leerString("Desea agregar una clasificacion?").equalsIgnoreCase("S")? 
				new Clasificacion(Teclado.leerString("Clasificacion:"))  
				:new Clasificacion());
		pojo.setSinopsis(Teclado.leerString("Sinopsis:"));
		pojo.setDirector(Teclado.leerString("Director:"));
		List<String> actores = new ArrayList<>();
		do {
			actores.add(Teclado.leerString("Actor:"));
		} while (Teclado.leerString("Desea seguir agregando?").equalsIgnoreCase("S"));
		pojo.setReparto(actores);
		pojo.setWeb(Teclado.leerString("Desea agregar una web?").equalsIgnoreCase("S")? 
				Teclado.leerString("Web:")  
				:null);
		pojo.setCartel(Teclado.leerString("Desea agregar un cartel?").equalsIgnoreCase("S")? 
				Teclado.leerString("Cartel:")  
				:null);
	}

}
