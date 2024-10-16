package org.dam2.empleydepart;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class BooleanToText extends AbstractBeanField<String, Boolean>{

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		// TODO Auto-generated method stub
		
		Boolean sexo;
		
		sexo = value.equals("Mujer");
		
		return sexo;
	}


	@Override
    protected String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException 
	{
		Boolean sexo = (Boolean) value;
		
		return sexo?"Mujer":"Hombre";
	}
}
