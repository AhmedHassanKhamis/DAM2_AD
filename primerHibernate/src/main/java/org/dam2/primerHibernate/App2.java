package org.dam2.primerHibernate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dam2.primerHibernate.modelo.Alumno;
import org.dam2.primerHibernate.modelo.Grupo;
import org.dam2.primerHibernate.utilidadeshibernate.GenericJPADAO;

import lombok.var;



public class App2 
{
    public static void main( String[] args )
    {
    	Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        GenericJPADAO <Alumno,Integer> alumnoDAO ;
        GenericJPADAO <Grupo, String> grupoDAO ;
		List<Alumno> alumnos;
//		List<Grupo> grupos = new ArrayList<Grupo>();
		
		
		alumnoDAO = new GenericJPADAO (Alumno.class,"hibernate");
		grupoDAO = new GenericJPADAO(Grupo.class, "hibernate");
		//1-CREAR LAS TABLAS
		//2-CREAR UNA APP QUE HAGA:
//				-INSERTAR 3 ALUMNOS.
		var alumno1 = Alumno.builder().
				firstName("miguel").
				fecha(LocalDate.now()).
				build();

		var alumno2 = Alumno.builder().
				firstName("rosa").
				fecha(LocalDate.now().minusWeeks(6)).
				build();
		
		var alumno3 = Alumno.builder().
				firstName("fernando").
				fecha(LocalDate.now()).
				build();
		// Insertar alumnos

//		System.out.println("Insertando...");
//		alumno1 = alumnoDAO.save(alumno1);
//		alumno2 = alumnoDAO.save(alumno2);
//		alumno3 = alumnoDAO.save(alumno3);
		
		
		
		
//		-INSERTAR 2 GRUPOS.
		
		var grupo1 = Grupo.builder()
					.nombre("DAW")
					.tutor("Miguel")
					.curso(2)
					.alumnos(List.of(alumno1,alumno2))
					.build();
		
		
		var grupo2 = Grupo.builder()
				.nombre("DAM")
				.tutor("Mario")
				.curso(2)
				.alumnos(List.of(alumno3))
				.build();
		
		grupo1 = grupoDAO.save(grupo1);
		grupo2 = grupoDAO.save(grupo2);
		
//		grupos.addAll(List.of(grupo1,grupo2));
		
		
		
//				-CAMBIAR 1 ALUMNO DE GRUPO
//		Alumno alumnoModificar = alumnoDAO.findById(1).get();
//		alumnoModificar.setGrupo("DAM");
//		alumnoDAO.update(alumnoModificar);
		
		Grupo grupoBuscado = grupoDAO.findById("DAW").get();
		Grupo grupoDeseado = grupoDAO.findById("DAM").get();
		Alumno alumnoCambiar = grupoBuscado.getAlumnos().stream().filter(a -> a.getId() == 1).findFirst().get();
		grupoBuscado.getAlumnos().remove(alumnoCambiar);
		grupoDeseado.getAlumnos().add(alumnoCambiar);
		grupoDAO.update(grupoBuscado);
		grupoDAO.update(grupoDeseado);
		
//				-BORRAR  1 ALUMNO
//		alumnoDAO.delete(alumnoDAO.findById(1).get());

//				-BORRAR 1 GRUPO
		Grupo grupoBuscado2 = grupoDAO.findById("DAW").get();
		Grupo grupoDeseado2 = grupoDAO.findById("DAM").get();
		List<Alumno> alumnosCambiarGrupo = new ArrayList(grupoBuscado2.getAlumnos());
		grupoBuscado2.getAlumnos().clear();;
		grupoDAO.update(grupoBuscado2);
		grupoDeseado2.getAlumnos().addAll(alumnosCambiarGrupo);
		grupoDAO.update(grupoDeseado2);
		grupoDAO.delete(grupoDAO.findById("DAW").get());


		//3- MOSTRAR  LOS DATOS DE UN GRUPO
//		grupoDAO.findById("DAM").stream().forEach(System.out::println);
		
				
		
		
//		
//		alumnos = (List<Alumno>) alumnoDAO.findAll();
//        
//		alumnos.forEach(System.out::println);
    }
}
