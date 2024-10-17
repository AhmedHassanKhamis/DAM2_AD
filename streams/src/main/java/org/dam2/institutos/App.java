package org.dam2.institutos;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class App {

	public static void main(String[] args) {

		List<Instituto> institutos = cargarDatos();
		institutos.stream().forEach(i -> System.out.println(i));
		
	}

	
	
	public static List<Instituto> cargarDatos(){
		List<Instituto> institutos = new ArrayList<Instituto>();
		
		try {
			institutos = new CsvToBeanBuilder(new FileReader("institutos.csv"))
					.withType(Instituto.class)
					.build()
					.parse();
		} catch (Exception e) {
			System.out.println(e);
		}
		return institutos;
		
		
	}
}
