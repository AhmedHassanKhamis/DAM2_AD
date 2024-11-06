package org.dam2.ejercicioCSVCiclismo;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class BooleanAdapter extends AbstractBeanField<String, Boolean> {

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		// TODO Auto-generated method stub
		Boolean profesional = value.equalsIgnoreCase("si");
		
		return profesional;
	}
	
	@Override
	protected String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		// TODO Auto-generated method stub
		Boolean profesional = (Boolean) value;
		
		return profesional?"si":"no";
	}

}
