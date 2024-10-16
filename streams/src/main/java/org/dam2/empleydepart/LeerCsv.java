package org.dam2.empleydepart;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import com.opencsv.bean.CsvToBeanBuilder;

public class LeerCsv {

	public static void main(String[] args) throws IllegalStateException, FileNotFoundException {
		// TODO Auto-generated method stub

		List<Depart> beans = new CsvToBeanBuilder(new FileReader("departamentos.csv"))
                .withType(Depart.class)
                .build()
                .parse();

		// ajustar jefes
		Consumer<Emple> ponerJefe = e -> e.setJefe(
						beans.stream().
							flatMap(d ->d.getEmpleados().stream()). // stream de empleados
							map(Emple::getJefe). // stream de jefes de empleados
							filter(Optional::isPresent).// filtrar los vacíos
							map(Optional::get). // datos de jefes
							distinct(). // eliminar repetidos
							filter(j -> j.getDni().equals(e.getJefe().get().getDni())). // quedarnos con el jefe del empleado
							findFirst() // consumir
						);
		
		
		beans.stream().
				flatMap(d -> d.getEmpleados().stream()). // stream empleados
				filter(e -> e.getJefe().isPresent()). // eliminar los que no tienen jefe
				forEach(ponerJefe); // cambiar el jefe con sólo dni, por el valor real del jefe
						

       beans.forEach(System.out::println);
	}

}
