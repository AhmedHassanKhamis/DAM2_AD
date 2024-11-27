package org.dam2.primerHibernate;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dam2.primerHibernate.modelo.Alumno;
import org.dam2.primerHibernate.utilidadeshibernate.GenericJPADAO;

import lombok.var;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        System.out.println( "Hello World!" );
        GenericJPADAO <Alumno,Integer> alumnoDAO ;
		List<Alumno> alumnos;
		
		
		alumnoDAO = new GenericJPADAO (Alumno.class,"hibernate");

		// Insertar alumnos
		var alumno1 = Alumno.builder().
					firstName("miguel").
					fecha(LocalDate.now()).
					build();

		var alumno2 = Alumno.builder().
				firstName("rosa").
				fecha(LocalDate.now().minusWeeks(6)).
				build();
		
		System.out.println("Insertando...");
		alumno1 = alumnoDAO.save(alumno1);
		alumno2 = alumnoDAO.save(alumno2);
		
		alumnos = (List<Alumno>) alumnoDAO.findAll();
        
		alumnos.forEach(System.out::println);
    }
}
