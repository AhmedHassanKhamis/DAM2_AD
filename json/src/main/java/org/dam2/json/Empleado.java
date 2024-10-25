package org.dam2.json;

import java.time.LocalDate;

import com.google.gson.annotations.JsonAdapter;
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
public class Empleado {
	@EqualsAndHashCode.Include
	private String id;
	private String nombre;
	@SerializedName(value = "departamento")
	private String dept;
	private float  sueldo;
//	@JsonAdapter(LocalDateAdapter.class)
	@JsonAdapter(LocalDateSplitValuesAdapter.class)
	private LocalDate fechaNacimiento;
	

}
