package org.dam2.ejercicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.dam2.modelo.Alumno;
import org.dam2.modelo.Calificacion;
import org.dam2.modelo.Direccion;
import org.dam2.modelo.Grupo;
import org.dam2.modelo.Modulo;
import org.dam2.modelo.Profesor;
import org.dam2.utilidadeshibernate.GenericJPADAO;

import daw.com.Teclado;

/**
 * Hello world!
 *
 */
public class App 
{
	 private GenericJPADAO <Alumno,String> alumnoDAO ;
	 private GenericJPADAO <Grupo, String> grupoDAO ;
	 private GenericJPADAO <Direccion,Integer> direccionDAO ;
	 private GenericJPADAO <Profesor, String> profesorDAO ;
	 private GenericJPADAO <Modulo, Integer> moduloDAO ;
	 private GenericJPADAO <Calificacion, Integer> calificacionDAO ;

	
	
    public static void main( String[] args )
    {
    	App app = new App();
    	app.InicializarDAO();
    	app.CargarDatos();
    	app.PonerNotas();
//    	app.ListarAlumnosGrupo();
//    	app.ListarModulosAlumno();
//    	app.EliminarAlumno();
//    	app.EliminarAlumnosGrupo();
//    	app.SubirPunto();
//    	app.MostrarAprobados();
    	
    	    
    }
    
    public void MostrarAprobados() {
    	List<Calificacion> calificaciones = (List<Calificacion>) calificacionDAO.findAll();
    	String modulo = Teclado.leerString("Modulo en el que mostrar aprobados:");
    	calificaciones.stream().filter(c->c.getModulo().getNombre().equalsIgnoreCase(modulo)).filter(c -> c.getNota() >= 5).forEach(System.out::println);
    }
    
    
    
    
    public void SubirPunto() {
    	List<Calificacion> calificaciones = (List<Calificacion>) calificacionDAO.findAll();
    	String modulo = Teclado.leerString("Modulo en el que subir nota:");
    	calificaciones.stream().filter(c->c.getModulo().getNombre().equalsIgnoreCase(modulo)).forEach(System.out::println);
    	calificaciones.stream().filter(c -> c.getModulo().getNombre().equalsIgnoreCase(modulo)).map(c -> {
    		c.setNota(c.getNota() + 1);
    		return c;
    	}).forEach(calificacionDAO::update);
    }
    
    
    
    
    public void EliminarAlumnosGrupo(){
    	
    	List<Grupo> grupos = (List<Grupo>)grupoDAO.findAll();
    	List<Calificacion> calificaciones = (List<Calificacion>) calificacionDAO.findAll();

    	String nombreGrupo = Teclado.leerString("introduce el nombre del grupo:");
    	
    	
    	List<Alumno> alumnosGrado = grupos.stream().filter(g -> g.getNombre().equalsIgnoreCase(nombreGrupo))
    	    	.flatMap(g -> g.getAlumnos().stream()).toList(); 
    	
    	calificaciones.stream().filter(c -> alumnosGrado.contains(c.getAlumno())).forEach(calificacionDAO::delete);
    	alumnosGrado.stream().forEach(alumnoDAO::delete);
    }
    
    
    
    
    public void EliminarAlumno() {
    	String dni = Teclado.leerString("introduce el dni del alumno a eliminar:");
    	Alumno alumno = alumnoDAO.findById(dni).get();
    	List<Calificacion> calificaciones = (List<Calificacion>) calificacionDAO.findAll();

    	calificaciones.stream().filter(c -> c.getAlumno().equals(alumno)).forEach(calificacionDAO::delete);
    	alumnoDAO.delete(alumno);
    }
    
    
    
    
    public void ListarModulosAlumno() {
    	List<Grupo> grupos = (List<Grupo>)grupoDAO.findAll();
    	List<Calificacion> calificaciones = new ArrayList<Calificacion>();

    	String nombreGrupo = Teclado.leerString("introduce el nombre del grupo:");
    	
    	Alumno alumno = grupos.stream().filter(g -> g.getNombre().equalsIgnoreCase(nombreGrupo))
    	.flatMap(g -> g.getAlumnos().stream()).findFirst().orElse(null);
    	
//    	if(alumno != null) {
          calificaciones = (List<Calificacion>) calificacionDAO.findAll();
          calificaciones.stream().filter(c -> c.getAlumno().equals(alumno)).map(c -> c.getModulo().getNombre()).distinct().forEach(System.out::println);
//    	}
    }
    
    
    
    public void ListarAlumnosGrupo() {
    	List<Grupo> grupos = (List<Grupo>)grupoDAO.findAll();
    	String nombreGrupo = Teclado.leerString("introduce el nombre del grupo:");
    	grupos.stream().filter(g -> g.getNombre().equalsIgnoreCase(nombreGrupo))
    	.flatMap(g -> g.getAlumnos().stream()).forEach(System.out::println);;
    }
    
    
    
    public void PonerNotas() {
    	List<Grupo> grupos = new ArrayList<Grupo>();
    	List<Calificacion> calificaciones = new ArrayList<Calificacion>();
    	final List<Modulo> modulos = (List<Modulo>)moduloDAO.findAll();
    	
    	grupos = (List<Grupo>)grupoDAO.findAll();
    	
    	Random random = new Random();
//    	grupos.stream().flatMap(g -> g.getAlumnos().stream()).to
    	grupos.stream().forEach(g -> g.getAlumnos().forEach(a ->modulos.stream().forEach( m -> {
    		Calificacion calificacion = Calificacion.builder()
    				.alumno(a)
    				.modulo(m)
    				.nota(random.nextFloat(10 - 1 + 1) + 1)
    				.build();
    		calificacionDAO.save(calificacion);
    	})));
    	

    	calificaciones = (List<Calificacion>) calificacionDAO.findAll();
    	
    	calificaciones.stream().forEach(c -> {
//    		QUITAR LAS CALIFICACIONES QUE NO PERTENECEN AL MISMO GRADO
//    		PROBLEMA: SI SOLO TENGO LA TABLA DE CALIFICACIONES COMO PUEDO COMPROBAR
//    		QUE NO SON DE OTRO GRADO
    
//    		if (c.getModulo().getImpartidor() ) {
    			
				//pense en pillar o comprobar la relacion por parte del tutor
//    			pero no tiene sentido porque no todos los profesores son tutores
//			}
    	});
    }
    
    
    public void InicializarDAO() {
    	alumnoDAO = new GenericJPADAO (Alumno.class,"hibernate");
		grupoDAO = new GenericJPADAO(Grupo.class, "hibernate");    
		direccionDAO = new GenericJPADAO (Direccion.class,"hibernate");
		profesorDAO = new GenericJPADAO(Profesor.class, "hibernate");    
		moduloDAO = new GenericJPADAO (Modulo.class,"hibernate");
		calificacionDAO = new GenericJPADAO(Calificacion.class, "hibernate");    
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
    	 
    	 modulos.stream().forEach(moduloDAO::save);
    	 grupos.stream().forEach(grupoDAO::save);
    			 
    	
    }
    
}
