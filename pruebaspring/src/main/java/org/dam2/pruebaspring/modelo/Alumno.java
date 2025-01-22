package org.dam2.pruebaspring.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Alumno {
	@EqualsAndHashCode.Include
	@Id
	private String nia;
	 
	private String nombre;
	
	private LocalDate fecha;
	
	
	private int nota;
	
	

}
