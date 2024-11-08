package org.dam2.ejercicio2;

import java.time.LocalTime;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class TiempoAdapter extends AbstractBeanField<String, LocalTime>{

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		// TODO Auto-generated method stub
		
		
		return (value == null)?LocalTime.parse("00:00:00") :LocalTime.parse(value);
	}
	
	
	protected String convertToWrite(Object value) throws CsvDataTypeMismatchException  {
		// TODO Auto-generated method stub
		
		
		return value.toString();
	}

}
