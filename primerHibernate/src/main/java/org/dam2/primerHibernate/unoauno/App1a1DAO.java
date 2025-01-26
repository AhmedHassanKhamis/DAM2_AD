package org.dam2.primerHibernate.unoauno;



import java.time.LocalDate;

import org.dam2.primerHibernate.utilidadeshibernate.GenericJPADAO;


public class App1a1DAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericJPADAO <Alumno,Integer> alumnoDAO ;
		String PERSISTENCE_UNIT = "unoauno";

		alumnoDAO = new GenericJPADAO (Alumno.class,PERSISTENCE_UNIT);


        Direccion d = Direccion.builder().  
        		//idDireccion(1).
				calle("calle").
				numero(34).
				poblacion("poblacion").
				provincia("provincia").
				build();

        // guardar alumno
        Alumno alumno = Alumno.builder().
        					//id(1).
        					firstName("ana").
        					fecha(LocalDate.now()).
        					direccion(d).
        					build();
        
               
        alumno = alumnoDAO.save(alumno);
        //System.out.println(alumno);
        
        System.out.println("consultando...");
        
        //alumnoDAO.findById(1).ifPresent(System.out::println);
        
        alumnoDAO.findAll().forEach(System.out::println);
        
        alumno = alumnoDAO.findById(2).get();
        
        alumno.setFecha(LocalDate.now().minusYears(2));
        alumnoDAO.update(alumno);
        
        System.out.println("Listar todos");
        alumnoDAO.findAll().forEach(System.out::println);
        
	}

}
