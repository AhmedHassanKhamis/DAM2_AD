package org.dam2.ejercicioEbay;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class App {

	public static void main(String[] args) {
		Usuario usuario1,usuario2,usuario3;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuario1 = new Usuario("Juan", 100, "juan@gmail.com");
		usuario2 = new Usuario("Pedro",150,"pedro@hotmail.com");
		usuario3 = new Usuario("Enrique",300,"enrique@rolex.com");
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		
		
		Subasta subasta = new Subasta("Teléfono Móvil", usuario1);
		
		subasta.pujar(usuario2, 100);
		System.out.println(subasta.getPujaMayor());
		subasta.pujar(usuario3, 50);
		System.out.println(subasta.getPujaMayor());
		subasta.ejecutar();
		
		System.out.println(usuario1.getCredito());
		System.out.println(usuario2.getCredito());
		System.out.println(usuario3.getCredito());
		
//		CONSULTAS EJERCICIOS 
//		1. Cuenta los usuarios que tienen cuenta de correo en Gmail. Muestra el resultado en la consola.
		Consumer<Usuario> Escribidor = System.out::println;
		usuarios.stream().filter(p -> p.getEmail().contains("@gmail")).forEach(Escribidor);
		
		
//		2. Mostrar por la consola los nombres de usuarios que sean propietarios de subastas ordenados por orden alfabético inverso.
		List<Subasta> subastas = new ArrayList<Subasta>();
		subastas.add(subasta);
		subastas.stream().map(Subasta::getPropietario).map(Usuario::getNombre).distinct().sorted((n1,n2) -> n2.compareTo(n1)).forEach(System.out::println);
		
//		3. Mostrar por la consola los nombres de los productos cuyas subastas hayan recibido alguna puja ordenados alfabéticamente.
		
		subastas.stream().filter(s -> !s.getPujas().isEmpty()).map(Subasta::getProducto).sorted(String::compareTo).forEachOrdered(System.out::println);
		
//		4. Mostrar por la consola el nombre de los productos de aquellas subastas que hayan recibido pujas superiores a 50 euros.
		
		subastas.stream().filter(s -> s.getPujaMayor().get().getCantidad() > 50).map(Subasta::getProducto).forEach(System.out::println);
		
//		5. Consultar si hay usuarios que hayan ganado alguna subasta y que sean propietarios de subastas.
		
		List<String> propietarios = subastas.stream().filter(Subasta::estaAbierto).map(Subasta::getPropietario).map(Usuario::getNombre).toList();
		List<String> ganadores = subastas.stream().map(s -> s.getPujaMayor().get().getPujador()).map(Usuario::getNombre).toList();
		System.out.println((ganadores.stream().anyMatch(n -> propietarios.contains(n)))?"Existe un ganador de subasta y que es dueño de alguna":"No existe un ganador de subasta y propietario de alguna");

//		6. Crea un conjunto vacío de pujas, añade a ese conjunto todas las pujas que se hayan realizado	en las subastas
		
		List<Puja> pujas = subastas.stream().flatMap(s -> s.getPujas().stream()).toList();
		System.out.println(pujas);
		
		
		
	}

}
