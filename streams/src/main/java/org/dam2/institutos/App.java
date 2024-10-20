package org.dam2.institutos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class App {
	private static final Comparator<Instituto> COMPARADORNOMBRESINSTITUTO = (p1, p2) -> p1.getNombre()
			.compareTo(p2.getNombre());
	private static final Consumer<Object> ESCRIBIDOR = System.out::println;
	private static final Predicate<Persona> MAYORDEEDAD = p -> p.getFechaNacimiento().plusYears(18)
			.isBefore(LocalDate.now());

	public static void main(String[] args) {

		List<Instituto> institutos = cargarDatos();
		guardarDatos(institutos);

		
//		institutos.stream().forEach(i -> System.out.println(i));

//		no se que hago en la de abajo full random jajajjaa
//		institutos.stream().filter(i -> i.getNumero().startsWith("28")).flatMap(i -> i.getPersonas().stream()).sorted().map(p -> p.getNombre() + p.getTelefonos()).forEach(System.out::println);;

//		Listado del nombre y el número de teléfono, ordenado por nombre, de todos los institutos cuyo código de centro comience por “28”.

//		institutos.stream().filter(i -> i.getNumero().startsWith("28")).sorted(COMPARADORNOMBRESINSTITUTO).map(i -> i.getNombre()+"->"+i.getNumero()).forEach(ESCRIBIDOR);;

//		Listado del nombre de todas las personas de todos los institutos que tengan un vehículo de color “verde”.

//		institutos.stream().flatMap(i-> i.getPersonas().stream()).filter(p-> !p.getVehiculo().isEmpty()).filter(p -> p.getVehiculo().get().getColor().equalsIgnoreCase("verde")).map(Persona::getNombre).forEach(ESCRIBIDOR);

//		Listado de todas las compañías de telecomunicaciones de todas las personas mayores de edad de todos los institutos.

		institutos.stream().flatMap(i-> i.getPersonas().stream()).filter(MAYORDEEDAD).flatMap(p-> p.getTelefonos().stream()).map(Telefono::getCompania).distinct().forEach(ESCRIBIDOR);

//		Total del presupuesto de todos los institutos que tengan más de una persona.

//		institutos.stream().filter(i-> i.getPersonas().size() > 1).map(Instituto::getPresupuesto).forEach(ESCRIBIDOR);
//		System.out.println(institutos.stream().filter(i-> i.getPersonas().size() > 1).mapToDouble(Instituto::getPresupuesto).sum());

//		Listado de los centros de adultos, es decir los institutos que no tengan alumnos menores de edad.

//		institutos.stream().filter(i->i.getPersonas().stream().allMatch(MAYORDEEDAD)).forEach(ESCRIBIDOR);

//		Listado del nombre y todos los datos de todos los teléfonos de contactos de todas las personas menores de edad por nombre de instituto.

//		institutos.stream()
//				.collect(
//						Collectors
//								.groupingBy(Instituto::getNombre,
//										Collectors.flatMapping(
//												i -> i.getPersonas().stream()
//														.filter(p -> p.getFechaNacimiento().plusYears(18)
//																.isAfter(LocalDate.now()))
//														.map(p -> p.getNombre() + "->" + p.getTelefonos()),
//												Collectors.toList())))
//				.entrySet().forEach(ESCRIBIDOR);
		
		
		

	}

	public static List<Instituto> cargarDatos() {
		List<Instituto> institutos = new ArrayList<Instituto>();

		try {
			institutos = new CsvToBeanBuilder(new FileReader("institutosXXX.csv")).withType(Instituto.class).build()
					.parse();
		} catch (Exception e) {
			System.out.println(e);
		}
		return institutos;

	}

	public static void guardarDatos(List<Instituto> institutos) {
		try {
			Writer writer = new FileWriter("institutosXXX.csv");
			CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
		     
		     StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
		     beanToCsv.write(institutos);
		     writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
