package org.dam2.ejercicio2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Corredor corredor1 = Corredor.builder()
//				.nombre("ahmed")
//				.dni("001")
//				.edad(22)
//				.categoria(Categoria.VETERANO)
//				.tiempo(LocalTime.parse("00:10:00"))
//				.build();
//		
//		Corredor corredor2 = Corredor.builder()
//				.nombre("Miguel")
//				.dni("002")
//				.edad(18)
//				.categoria(Categoria.VETERANO)
//				.tiempo(LocalTime.parse("00:01:00"))
//				.build();
//		
//		Corredor corredor3 = Corredor.builder()
//				.nombre("Mario")
//				.dni("003")
//				.edad(19)
//				.categoria(Categoria.ADULTO)
//				.tiempo(LocalTime.parse("22:59:59"))
//				.build();
//		
//		Carrera carrera1 = Carrera.builder()
//				.nombre("Perroton")
//				.metros(10000)
//				.cupo(20)
//				.corredores(List.of(corredor1,corredor2,corredor3))
//				.build();
//
//		
//
//		Corredor corredor4 = Corredor.builder()
//				.nombre("Begoña")
//				.dni("004")
//				.edad(30)
//				.categoria(Categoria.ADULTO)
//				.tiempo(LocalTime.parse("20:00:00"))
//				.build();
//		
//		Corredor corredor5 = Corredor.builder()
//				.nombre("TorreSanos")
//				.dni("005")
//				.edad(21)
//				.categoria(Categoria.VETERANO)
//				.tiempo(LocalTime.parse("00:20:00"))
//				.build();
//		
//		Corredor corredor6 = Corredor.builder()
//				.nombre("Gonzalo")
//				.dni("006")
//				.edad(20)
//				.categoria(Categoria.ADULTO)
//				.tiempo(LocalTime.parse("21:00:00"))
//				.build();
//		
//		Carrera carrera2 = Carrera.builder()
//				.nombre("Iron Man")
//				.metros(40000)
//				.cupo(100)
//				.corredores(List.of(corredor4,corredor5,corredor6))
//				.build();
//
//		
//		
//		List<Carrera> carreras = List.of(carrera1,carrera2);
//		System.out.println(carreras);
//		escribirCsv(carreras);
		
		
		
		List<Carrera>carreras = leerCsv();
//		System.out.println(carreras);
		
		
//		1- Listado del nombre de las carreras que no hayan agotado el cupo de corredores,
//		es decir que la cantidad de corredores sea menor al cupo
		
//		carreras.stream().filter(carrera -> carrera.getCupo() > carrera.getCorredores().size()).map(Carrera::getNombre).forEach(System.out::println);
		
//		2- Listado del nombre y la edad de los corredores que han realizado carreras de,
//		mas de 200 metros en menos de una hora y media
		
//		carreras.stream().filter(carrera -> carrera.getMetros() > 200).flatMap(carrera -> carrera.getCorredores().stream()).filter(corredor -> corredor.getTiempo().isBefore(LocalTime.parse("01:30:00"))).map(corredor -> corredor.getNombre() + " -> " + corredor.getEdad()).forEach(System.out::println);
		
//		3- Listado de los dni de corredores que han participado en mas de una carrera
		
//		List<Corredor> corredoresCarrera1 = carreras.stream().filter(carrera -> carrera.getNombre().equalsIgnoreCase("Perroton")).flatMap(carrera -> carrera.getCorredores().stream()).toList();
//		List<Corredor> corredoresCarrera2 = carreras.stream().filter(carrera -> carrera.getNombre().equalsIgnoreCase("Iron Man")).flatMap(carrera -> carrera.getCorredores().stream()).toList();
		
		
//		carreras.stream().filter(carrera -> carrera.getCorredores().stream().anyMatch(corredor -> corredoresCarrera1.contains(corredor) || corredoresCarrera2.contains(corredor))).flatMap(carrera -> carrera.getCorredores().stream()).map(Corredor::getDni).forEach(System.out::println);
//		carreras.stream().filter(carrera -> carrera.getCorredores().stream().anyMatch(corredor -> carreras.stream().anyMatch(carrera -> carrera.getCorredores().contains(corredor)))).flatMap(carrera -> carrera.getCorredores().stream()).map(Corredor::getDni).forEach(System.out::println);

//		List<String> carrerasNombre = carreras.stream().map(Carrera::getNombre).toList();
//		carreras.stream().filter(carrera -> carrera.getCorredores().stream().anyMatch(corredor -> carreras.stream().).flatMap(carrera -> carrera.getCorredores().stream()).map(Corredor::getDni).forEach(System.out::println);

		
//		4- Listado de las carreras con sus ganadores, es decir se debe mostrar el nombre
//		de la carrera y el dni del ganador. el ganador de una carrera es el corredor que
//		menor tiempo ha tardado en realizarla.
//		List<LocalTime> tiemposGanadores = carreras.stream().flatMap(carrera -> carrera.getCorredores().stream())
		Predicate<Corredor> mejorTiempo = corredor -> corredor.getTiempo().equals(carreras.stream().flatMap(carrera -> carrera.getCorredores().stream()).map(Corredor::getTiempo).sorted((t1,t2)-> t1.compareTo(t2)).findFirst().orElse(LocalTime.parse("23:59:59")));
		System.out.println("PRIMER INTENTO");
		carreras.stream().collect(Collectors.groupingBy(Carrera::getNombre, Collectors.flatMapping(carrera -> carrera.getCorredores().stream().filter(mejorTiempo), Collectors.toList()))).forEach((clave,valor) -> System.out.println(clave + "->" + valor));;
		System.out.println("SEGUNDO INTENTO");
		carreras.stream().collect(Collectors.groupingBy(Carrera::getNombre, Collectors.mapping(carrera -> carrera.getCorredores().stream().filter(mejorTiempo).findFirst().orElse(new Corredor()), Collectors.toList()))).forEach((clave,valor) -> System.out.println(clave + "->" + valor));;
		
		

	}
	
	public static List<Carrera> leerCsv(){
		List<Carrera> carreras = new ArrayList<Carrera>();
		try {
			carreras = new CsvToBeanBuilder(new FileReader("carreras.csv"))
					.withType(Carrera.class)
					.build()
					.parse();// stream()
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return carreras;
	}
	
	public static void escribirCsv(List<Carrera> carreras) {
		try {
			Writer writer = new FileWriter("carreras.csv");
			StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).
					withSeparator(',').
					withApplyQuotesToAll(false).
					build();
					beanToCsv.write(carreras);
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		System.out.println("Fichero escrito!");
			
		
	}

}
