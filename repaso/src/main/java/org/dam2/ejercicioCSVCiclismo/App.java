package org.dam2.ejercicioCSVCiclismo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Vuelta> vueltas = leerCsv();

//		
//		Corredor corredor1 = Corredor
//				.builder()
//				.dni("001")
//				.nombre("Ahmed")
//				.fechaNacimiento(LocalDate.parse("2001-01-01"))
//				.profesional(true)
//				.build();
//		
//
//		Corredor corredor2 = Corredor
//				.builder()
//				.dni("002")
//				.nombre("Dylan")
//				.fechaNacimiento(LocalDate.parse("2002-02-02"))
//				.profesional(true)
//				.build();
//		
//
//		Corredor corredor3 = Corredor
//				.builder()
//				.dni("003")
//				.nombre("Derlys")
//				.fechaNacimiento(LocalDate.parse("2003-03-03"))
//				.profesional(false)
//				.build();
//		
//
//		Corredor corredor4 = Corredor
//				.builder()
//				.dni("004")
//				.nombre("Miguel")
//				.fechaNacimiento(LocalDate.parse("2004-04-04"))
//				.profesional(false)
//				.build();
//		
//		Corredor corredor5 = Corredor
//				.builder()
//				.dni("005")
//				.nombre("Antonio")
//				.fechaNacimiento(LocalDate.parse("2005-05-05"))
//				.profesional(true)
//				.build();
//		
//		Corredor corredor6 = Corredor
//				.builder()
//				.dni("006")
//				.nombre("Mario")
//				.fechaNacimiento(LocalDate.parse("2006-06-06"))
//				.profesional(true)
//				.build();
//		
//		Corredor corredor7 = Corredor
//				.builder()
//				.dni("007")
//				.nombre("Gonzalo")
//				.fechaNacimiento(LocalDate.parse("2007-07-07"))
//				.profesional(false)
//				.build();
//		
//		Corredor corredor8 = Corredor
//				.builder()
//				.dni("008")
//				.nombre("Angela")
//				.fechaNacimiento(LocalDate.parse("2008-08-08"))
//				.profesional(false)
//				.build();
//		
//		Corredor corredor9 = Corredor
//				.builder()
//				.dni("009")
//				.nombre("Juan")
//				.fechaNacimiento(LocalDate.parse("2009-09-09"))
//				.profesional(true)
//				.build();
//		
//		Corredor corredor10 = Corredor
//				.builder()
//				.dni("010")
//				.nombre("Javier")
//				.fechaNacimiento(LocalDate.parse("2010-10-10"))
//				.profesional(true)
//				.build();
//		
//		Corredor corredor11 = Corredor
//				.builder()
//				.dni("011")
//				.nombre("Chema")
//				.fechaNacimiento(LocalDate.parse("2011-11-11"))
//				.profesional(false)
//				.build();
//		
//		Corredor corredor12 = Corredor
//				.builder()
//				.dni("012")
//				.nombre("Marian")
//				.fechaNacimiento(LocalDate.parse("2012-12-12"))
//				.profesional(false)
//				.build();
//		
//		Equipo equipo1 = Equipo
//				.builder()
//				.nombre("Esparragos")
//				.nombrePatrocinador("Nestlé")
//				.nacionalidad("España")
//				.donacion(50000f)
//				.build();
//		
//		equipo1.addCorredor(corredor1);
//		equipo1.addCorredor(corredor2);
//		
//		Equipo equipo2 = Equipo
//				.builder()
//				.nombre("Tomates")
//				.nombrePatrocinador("MasterChef")
//				.nacionalidad("España")
//				.donacion(20000f)
//				.build();
//		
//		equipo2.addCorredor(corredor3);
//		equipo2.addCorredor(corredor4);
//		
//		Equipo equipo3 = Equipo
//				.builder()
//				.nombre("Patatas")
//				.nombrePatrocinador("Pringles")
//				.nacionalidad("Estados Unidos")
//				.donacion(100000f)
//				.build();
//		
//		equipo3.addCorredor(corredor5);
//		equipo3.addCorredor(corredor6);
//		
//		Equipo equipo4 = Equipo
//				.builder()
//				.nombre("Cebollas")
//				.nombrePatrocinador("Beefious")
//				.nacionalidad("Madrid xd")
//				.donacion(70000f)
//				.build();
//		
//		equipo4.addCorredor(corredor7);
//		equipo4.addCorredor(corredor8);
//		
//		Equipo equipo5 = Equipo
//				.builder()
//				.nombre("Zanahoria")
//				.nombrePatrocinador("Mercadona")
//				.nacionalidad("Antartica")
//				.donacion(10000f)
//				.build();
//		
//		equipo5.addCorredor(corredor9);
//		equipo5.addCorredor(corredor10);
//		
//		Equipo equipo6 = Equipo
//				.builder()
//				.nombre("Pobres")
//				.nombrePatrocinador("PobrePatrocinador")
//				.nacionalidad("Pobrelandia")
//				.donacion(0f)
//				.build();
//		
//		equipo6.addCorredor(corredor11);
//		equipo6.addCorredor(corredor12);
//		
//		Vuelta vuelta1 = Vuelta
//				.builder()
//				.nombre("Perroton")
//				.anio(2024)
//				.premio(5000f)
//				.director("Pedro Sanchez")
//				.numeroEtapas(4)
//				.build();
//		
//		vuelta1.addEquipo(equipo1);
//		vuelta1.addEquipo(equipo2);
//		vuelta1.addEquipo(equipo3);
//		
//
//		Vuelta vuelta2 = Vuelta
//				.builder()
//				.nombre("Iron Man")
//				.anio(2017)
//				.premio(100000f)
//				.director("Rajoy")
//				.numeroEtapas(2)
//				.build();
//		
//		
//		vuelta2.addEquipo(equipo4);
//		vuelta2.addEquipo(equipo5);
//		vuelta2.addEquipo(equipo6);
//		
//		
//		
//		
//		vueltas.add(vuelta1);
//		vueltas.add(vuelta2);
//		

//		System.out.println(vueltas);
//		vueltas.stream().forEach(System.out::println);
//		escribirCsv(vueltas);

//		1-Listado del nombre, año y director de todas las vueltas con más de 10 etapas., ordenado por año en
//		sentido creciente (de menor a mayor) (1 punto)

//		vueltas.stream().filter(vuelta -> vuelta.getNumeroEtapas() > 10).sorted((v1,v2)-> v1.getAnio() - v2.getAnio()).map(vuelta -> vuelta.getNombre() + "->" + vuelta.getAnio() + "->" + vuelta.getDirector()).forEach(System.out::println);

//		2-Listado del nombre de todos los corredores que participen en vueltas ciclistas con un premio
//		superior a 30000 euros.

//		vueltas.stream().filter(vuelta -> vuelta.getPremio() > 3000).flatMap(vuelta -> vuelta.getEquipos().stream()).flatMap(equipo -> equipo.getCorredores().stream()).map(corredor -> corredor.getNombre()).forEach(System.out::println);

//		3-Listado de todos equipos con corredores profesionales menores de edad.

//		vueltas.stream().flatMap(vuelta -> vuelta.getEquipos().stream()).filter(equipo -> equipo.getCorredores().stream().anyMatch(corredor -> corredor.getFechaNacimiento().isAfter(LocalDate.now().minusYears(18)))).filter(equipo -> equipo.getCorredores().stream().anyMatch(corredor -> corredor.isProfesional())).forEach(System.out::println);

//		4-Listado del director de las vueltas que tengan patrocinadores de nacionalidad “española” desde
//		2010 a 2020 ambos incluidos.

//		vueltas.stream().filter(vuelta -> vuelta.getAnio() <= 2020 ).filter(vuelta -> vuelta.getAnio() >= 2010).filter(vuelta -> vuelta.getEquipos().stream().anyMatch(equipo -> equipo.getNacionalidad().equalsIgnoreCase("España"))).map(Vuelta::getDirector).forEach(System.out::println);;

//		5-Listado del nombre y dni de los corredores mayores de edad por nombre de vuelta ciclista. Es decir
//		para cada nombre de vuelta ciclista mostrar el nombre y el dni de sus corredores mayores de edad.

//		vueltas.stream().collect(Collectors.groupingBy(Vuelta::getNombre,
//				Collectors.flatMapping(Vuelta::getEquipos, Collectors.flatMapping(Equipo::getCorredores, Collectors))));

		vueltas.stream()
				.collect(Collectors.groupingBy(Vuelta::getNombre, Collectors.flatMapping(
						vuelta -> vuelta.getEquipos().stream().flatMap(equipo -> equipo.getCorredores().stream())
								.filter(corredor -> corredor.getFechaNacimiento()
										.isBefore(LocalDate.now().minusYears(18))),
						Collectors.mapping(corredor -> corredor.getNombre() + " -> " + corredor.getDni(),
								Collectors.toList()))))
				.forEach((nombreVuelta, corredores) -> {
					System.out.println(nombreVuelta + ": " + corredores);
				});

	}

	public static List<Vuelta> leerCsv() {
		List<Vuelta> vueltas = new ArrayList<Vuelta>();

		try {
			vueltas = new CsvToBeanBuilder(new FileReader("vueltas.csv")).withType(Vuelta.class).build().parse();// stream()

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return vueltas;
	}

	public static void escribirCsv(List<Vuelta> vueltas) {

		try {
			Writer writer = new FileWriter("vueltas.csv");
			StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).withSeparator(',')
					.withApplyQuotesToAll(false).build();
			beanToCsv.write(vueltas);
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
