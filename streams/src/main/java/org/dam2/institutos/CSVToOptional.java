package org.dam2.institutos;

import java.util.Optional;

import org.dam2.empleydepart.Emple;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CSVToOptional extends AbstractBeanField<String, Optional<Vehiculo>>{
	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		// TODO Auto-generated method stub
		Optional<Vehiculo> vehiculo;
		String [] campos = value.split("%");
		vehiculo = value.equals("SIN VEHICULO")?
					Optional.empty():
					Optional.of(Vehiculo.builder().matricula(campos[0]).modelo(campos[1]).color(campos[2]).build());
		
		return vehiculo;
	}
	

	@Override
    protected String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException 
	{
		
		Optional<Vehiculo> vehiculo = value== null? Optional.empty():Optional.of((Vehiculo)value);
		
		return vehiculo.map(v -> v.getMatricula()+"%"+v.getModelo()+"%"+v.getColor()).orElse("SIN VEHICULO");
		
	}

}
