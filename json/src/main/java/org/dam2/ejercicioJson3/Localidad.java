package org.dam2.ejercicioJson3;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded =  true)
public class Localidad {

	@SerializedName(value = "_c")
	private int id;
	@EqualsAndHashCode.Include
	@SerializedName(value = "__cdata")
	private String nombre;
	
	
}
