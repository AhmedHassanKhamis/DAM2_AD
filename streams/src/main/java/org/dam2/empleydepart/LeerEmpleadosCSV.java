package org.dam2.empleydepart;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class LeerEmpleadosCSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value = "00001A:Miguel:Mujer:1966-07-01:2000-01-20:34000.0:10000.0:profe:002";
		
		StringReader stringReader = new StringReader(value);
		
		//CSVReader csvReader = new CSVReaderBuilder(stringReader).build();
	
		
		
		CSVParser icsvParser = new CSVParserBuilder().withSeparator(':').build();
		CSVReader csvReader = new CSVReaderBuilder(stringReader).withCSVParser(icsvParser).build();
		
        List<Emple> arrayList= new CsvToBeanBuilder<Emple>(csvReader)
                                .withType(Emple.class)
                                .build()
                                .parse();
        //System.out.println(arrayList);
        
        escribirCSV (arrayList);

	}

	public static void escribirCSV(List<Emple> arrayList) {
		// TODO Auto-generated method stub
		Writer writer = new StringWriter();
			try {
			     StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).
			    		 withSeparator(':').
			    		 withApplyQuotesToAll(false).
			    		 build();
			     beanToCsv.write(arrayList);
			     System.out.println(writer.toString());
			} catch (CsvDataTypeMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CsvRequiredFieldEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
