package org.dam2.ejercicioCSVCiclismo;

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

public class CSVToCorredor extends AbstractCsvConverter {

	@Override
	public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		StringReader stringReader = new StringReader(value);
		CSVParser icsvParser = new CSVParserBuilder().withSeparator(':').build();
		CSVReader csvReader = new CSVReaderBuilder(stringReader).withCSVParser(icsvParser).build();
		List<Corredor> arrayList = new CsvToBeanBuilder<Corredor>(csvReader).withType(Corredor.class).build().parse();

		return arrayList;
	}

	@Override
	public String convertToWrite(Object value) throws CsvDataTypeMismatchException {
		// TODO Auto-generated method stub
		Writer writer = new  StringWriter(); 
		try {
			StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).
					withSeparator(':').
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
