package org.dam2.prueba;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PruebaLambdas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = new ArrayList<>();
		List<Alumno> alumnos1 = new ArrayList<>();

		
		Consumer<Alumno> escribidor, insertador;
		Predicate<Alumno> mayorDeEdad;
		Supplier<Alumno> productor;
		
		

	    Alumno a1,a2,a3;

	    a1 = Alumno.builder()
	    		.dni("001")
	    		.nombre("a1")
	    		.edad(20)
	    		.build();

	    a2 = Alumno.builder()
	    		.dni("002")
	    		.nombre("a2")
	    		.build();
	    
	    alumnos.add(a1);
	    alumnos.add(a2);
	    
	    System.out.println("seccion consumer o escribidor");
	    escribidor = a -> System.out.println(a);
	    
	    //para parametros que reciben salen es asi:
	    escribidor = System.out::println;
	    
	    
	    System.out.println("seccion predicador");
	    //si es solo un parametro no hace falta definir el parametro de entrada su tipo
	    mayorDeEdad = (Alumno a) -> a.getEdad() >= 18;
	    
	    alumnos.removeIf(mayorDeEdad.negate());
	    
	    alumnos.forEach(escribidor);

	    System.out.println("seccion productor");
	    productor = () ->  new Alumno ("00"+Math.random());
	    
	    alumnos.add(productor.get());
	    alumnos.add(productor.get());
	    
	    
	    alumnos.forEach(escribidor);

	    insertador = a -> alumnos1.add(a);
	    //insertador = alumnos1:add;
	    
	    alumnos.forEach(insertador);
	    System.out.println("seccion alumnos1");
	    alumnos1.forEach(escribidor);
	    
	}

}
