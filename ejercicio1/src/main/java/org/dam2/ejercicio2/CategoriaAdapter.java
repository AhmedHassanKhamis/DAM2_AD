package org.dam2.ejercicio2;

import java.util.Arrays;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class CategoriaAdapter extends AbstractBeanField<String, Categoria> {

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		// TODO Auto-generated method stub
		return Arrays.asList(Categoria.values()).stream().filter(c -> c.toString().equalsIgnoreCase(value)).findFirst().orElse(Categoria.ADULTO);
			
	}
	
	protected String convertToWrite(Object value) throws CsvDataTypeMismatchException {
		// TODO Auto-generated method stub
		return (value == null)?Categoria.ADULTO.toString():value.toString();
	}

}
