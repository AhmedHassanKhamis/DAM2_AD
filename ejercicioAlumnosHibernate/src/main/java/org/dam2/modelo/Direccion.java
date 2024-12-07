package org.dam2.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="Direcciones")
public class Direccion {

	@EqualsAndHashCode.Include
	@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "calle")
	private String calle;
	@Column(name = "portal")
	private int portal;
	@Column(name = "poblacion")
	private String poblacion;
	
}
