package org.dam2.opencsv;

import java.io.FileReader;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Stream;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class TextToAlumno extends AbstractCsvConverter {

	@Override
	public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		// TODO Auto-generated method stub
		StringReader stringReader = new StringReader(value);

		CSVParser icsvParser = new CSVParserBuilder().withSeparator(';').build();
		CSVReader csvReader = new CSVReaderBuilder(stringReader).withCSVParser(icsvParser).build();
		
		Stream <Alumno> beans = new CsvToBeanBuilder(csvReader)
                .withType(Alumno.class)
                //.withSeparator(';') // aquí no funciona
                .build()
                .stream();
		
		return beans.findFirst().orElseGet(Alumno::new);
	}

}
