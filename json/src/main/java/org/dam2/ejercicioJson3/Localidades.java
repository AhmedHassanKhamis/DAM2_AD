package org.dam2.ejercicioJson3;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Localidades {
	
	private List<Localidad> localidad;
	
	
	public Localidades ()
	{
		localidad = new ArrayList<>();
	}

}
