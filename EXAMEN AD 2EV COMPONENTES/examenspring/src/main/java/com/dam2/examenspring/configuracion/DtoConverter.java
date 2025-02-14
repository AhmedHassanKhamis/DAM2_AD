package com.dam2.examenspring.configuracion;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


public class DtoConverter {
	
	private ModelMapper modelMapper;
	
	public DtoConverter ()
	{
		modelMapper = new ModelMapper();
		        
		
	}
	
	 public <D, T> D map(final T input, Class<D> outClass) {
	        return modelMapper.map(input, outClass);
	 }
	 
	 public <D, T> List<D> mapAll(final Collection<T> inputList, Class<D> outCLass)
	 {
			        return inputList.stream()
			                .map(input -> map(input, outCLass))
			                .collect(Collectors.toList());
	 }
	 
	 public void inicializarBean ()
	 {
		// Establecer estrategia de conversión
	        modelMapper.getConfiguration().
	        				setMatchingStrategy(MatchingStrategies.LOOSE);

	 }
	 
}
