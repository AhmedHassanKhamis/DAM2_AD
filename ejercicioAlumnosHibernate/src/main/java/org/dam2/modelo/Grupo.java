package org.dam2.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
//Anotaciones Lombok
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

//Anotaciones JPA
@Entity
@Table(name="Grupos")
public class Grupo {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "ubicacion")
	private String ubicacion;
	
	
	//PENDIENTE ANOTACION
	private Profesor tutor;
	

}
