package org.dam2.prueba;

import java.util.Optional;
import java.util.function.Supplier;

public class PruebaOptional {

	public static void main(String[] args) {
		Optional<Alumno> alumno1, alumno2;
		Alumno a, a1;
		
		Runnable SINDATOS = () -> System.out.println("No hay datos");
		
		
		
		alumno1 = Optional.empty();
		
		
		 a  = Alumno.builder()
		    		.dni("001")
		    		.nombre("a1")
		    		.edad(20)
		    		.build();
		  
		 alumno2 = Optional.of(a);
		 
		 if (alumno1.isPresent())
			 System.out.println(alumno1.get());
		/*else
			 System.out.println("No hay alumnos");
		 

		 if (alumno2.isPresent())
			 System.out.println(alumno2.get());
		 else
			 System.out.println("No hay alumnos");
		 */
		 alumno1.ifPresent(System.out::println);

//		 alumno2.ifPresent(System.out::println);
		 alumno1.ifPresentOrElse(System.out::println, SINDATOS);
		 
//		 a1 = alumno1.orElse(new Alumno());
		 Supplier <Alumno> productor = () ->  new Alumno ("00"+Math.random());
		 
		 a1 = alumno2.orElseGet(productor);
		 
		 System.out.println(a1);
		 
		 
		 
		 alumno1.map(Alumno::getDni)
		 	.ifPresentOrElse(System.out::println, SINDATOS);
		 
		 alumno2.map(Alumno::getDni)
		 	.ifPresentOrElse(System.out::println, SINDATOS);
		 

		 
		 System.out.println("alumnos mayores de edad");
		 alumno1.filter(al -> al.getEdad() >= 18)
		 	.ifPresent(System.out::println);

		 
		 alumno2.filter(al -> al.getEdad() >= 18)
		 	.ifPresent(System.out::println);

		 alumno2.filter(al -> al.getEdad() >= 18).map(Alumno::getNombre).ifPresent(System.out::println);;
		 
		 System.out.println("fin");
		 
		 
	}

}
