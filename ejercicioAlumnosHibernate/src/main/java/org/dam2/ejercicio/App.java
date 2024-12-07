package org.dam2.ejercicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.dam2.modelo.Alumno;
import org.dam2.modelo.Direccion;
import org.dam2.modelo.Grupo;
import org.dam2.modelo.Modulo;
import org.dam2.modelo.Profesor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	
    	    
    }
    
    public void CargarDatos() {
    	List<Grupo> grupos = new ArrayList<Grupo>();
    	List<Modulo> modulos = new ArrayList<Modulo>();
    	
//   	 ---------- PROFESORES -------------
    	
    	 Profesor profesor1 = Profesor.builder()
    			 .dni("1344544L")
    			 .nombre("Juanjo")
    			 .especialidad("JavaScript")
    			 .build();
    	
    	 Profesor profesor2 = Profesor.builder()
    			 .dni("8920340M")
    			 .nombre("Roberto")
    			 .especialidad("Android")
    			 .build();
    	 
//   	 ---------- MODULOS -------------
     	
    	Modulo modulo1 = Modulo.builder()
    			.nombre("DI")
    			.impartidor(profesor1)
    			.build();
    	
    	Modulo modulo2 = Modulo.builder()
    			.nombre("DIW")
    			.impartidor(profesor1)
    			.build();
    	
    	Modulo modulo3 = Modulo.builder()
    			.nombre("DAW")
    			.impartidor(profesor2)
    			.build();
    	
    	Modulo modulo4 = Modulo.builder()
    			.nombre("PMDM")
    			.impartidor(profesor2)
    			.build();
    	
    	modulos.addAll(List.of(modulo1,modulo2,modulo3,modulo4));
    	 
//    	 ---------- DIRECCIONES -------------
    	 
    	 Direccion direccion1 = Direccion.builder()
    			 .calle("Josefa Valcarcel")
    			 .portal(5)
    			 .poblacion("Madrid")
    			 .build();
    	 
    	 Direccion direccion2 = Direccion.builder()
    			 .calle("San Cipriano")
    			 .portal(10)
    			 .poblacion("Madrid")
    			 .build();
    	 
    	 Direccion direccion3 = Direccion.builder()
    			 .calle("Arturo Soria")
    			 .portal(67)
    			 .poblacion("Madrid")
    			 .build();
    	 
    	 Direccion direccion4 = Direccion.builder()
    			 .calle("Marie Curie")
    			 .portal(5)
    			 .poblacion("Rivas Vaciamadrid")
    			 .build();
    	 
    	 Direccion direccion5 = Direccion.builder()
    			 .calle("Saturno")
    			 .portal(22)
    			 .poblacion("Parla")
    			 .build();
    	 
//    	 ---------- ALUMNOS -------------
    	 
    	 Alumno alumno1 = Alumno.builder()
    			 .dni("001A")
    			 .fechaNacimiento(LocalDate.of(2002, 5, 2))
    			 .nombre("Sebastian")
    			 .direccion(direccion1)
    			 .build();
    	 
    	 Alumno alumno2 = Alumno.builder()
    			 .dni("002A")
    			 .fechaNacimiento(LocalDate.of(2013, 1, 24))
    			 .nombre("Fernando")
    			 .direccion(direccion2)
    			 .build();
    	 
    	 Alumno alumno3 = Alumno.builder()
    			 .dni("003A")
    			 .fechaNacimiento(LocalDate.of(1991, 12, 3))
    			 .nombre("Laura")
    			 .direccion(direccion3)
    			 .build();
    	 
    	 Alumno alumno4 = Alumno.builder()
    			 .dni("004A")
    			 .fechaNacimiento(LocalDate.of(2007, 9, 16))
    			 .nombre("Santiago")
    			 .direccion(direccion4)
    			 .build();
    	 
    	 Alumno alumno5 = Alumno.builder()
    			 .dni("005A")
    			 .fechaNacimiento(LocalDate.of(1980, 6, 18))
    			 .nombre("Angela")
    			 .direccion(direccion5)
    			 .build();
    	 
//    	 ---------- GRUPOS -------------

    	 Grupo grupo1 = Grupo.builder()
    			 .nombre("DAW")
    			 .ubicacion("Aula 131")
    			 .alumnos(List.of(alumno1,alumno2,alumno3))
    			 .tutor(profesor1)
    			 .build();
    	 
    	 Grupo grupo2 = Grupo.builder()
    			 .nombre("DAM")
    			 .ubicacion("Aula 132")
    			 .alumnos(List.of(alumno4,alumno5))
    			 .tutor(profesor2)
    			 .build();
    	 
    	 grupos.addAll(List.of(grupo1,grupo2));
    	 
//    	 ---------- PARTE DONDE SE GUARDAN -------------    	 
    	 
    	 modulos.stream().forEach();
    	 grupos.stream().forEach();
    			 
    	
    }
    
}
