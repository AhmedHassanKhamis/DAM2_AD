package org.dam2.ejercicio2;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class CorredorAdapter extends AbstractCsvConverter{

	@Override
	public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		// TODO Auto-generated method stub
		
		StringReader stringReader = new StringReader(value);
		CSVParser icsvParser = new CSVParserBuilder().withSeparator('!').build();
		CSVReader csvReader = new
		CSVReaderBuilder(stringReader).withCSVParser(icsvParser).build();
		
		return new CsvToBeanBuilder(csvReader)
				.withType(Corredor.class)
				.build()
				.stream()
				.findFirst()
				.orElseGet(Corredor::new);
	}
	
	
	@Override
	public String convertToWrite(Object value) throws CsvDataTypeMismatchException {
		// TODO Auto-generated method stub
		Writer writer = new StringWriter();
		
		try {
			StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).
					withSeparator('!').
					withLineEnd("").
					withApplyQuotesToAll(false).
					build();
					beanToCsv.write(List.of(value));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	
		return writer.toString();
	}

}
