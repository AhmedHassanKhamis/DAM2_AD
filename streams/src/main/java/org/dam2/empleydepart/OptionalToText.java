package org.dam2.empleydepart;

import java.util.Optional;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OptionalToText extends AbstractBeanField<String, Optional<Emple>>{

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		// TODO Auto-generated method stub
		Optional<Emple> jefe;
		
		jefe = value.equals("sin jefe")?
					Optional.empty():
					Optional.of(Emple.builder().dni(value).jefe(Optional.empty()).build());
		
		return jefe;
	}
	

	@Override
    protected String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException 
	{
		
		Optional<Emple> jefe = value== null? Optional.empty():Optional.of((Emple)value);
		
		return jefe.map(Emple::getDni).orElse("sin jefe");
		
	}

}
