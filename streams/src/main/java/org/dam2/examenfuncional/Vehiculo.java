package org.dam2.examenfuncional;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehiculo {
	private String matricula;
	private String modelo;
	private String color;

}
