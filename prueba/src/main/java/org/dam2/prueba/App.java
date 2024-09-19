package org.dam2.prueba;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    Alumno a1,a2,a3;
    Grupo g;
    
    
    
    a1 = Alumno.builder()
    		.dni("001")
    		.nombre("a1")
    		.edad(20)
    		.build();

    a2 = Alumno.builder()
    		.dni("002")
    		.nombre("a2")
    		.build();
    
    
    
    g = Grupo.builder()
    		.nombre("g1")
    		.alumno(a1)
    		.alumno(a2)
    		.build();
    
    
    
    a3 = new Alumno ("003");

    g.addAlumno(a3);
    
    System.out.println(g);
    
    
    }
}
