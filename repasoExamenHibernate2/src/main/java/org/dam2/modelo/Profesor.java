package org.dam2.modelo;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

@Entity
@EntityListeners(ProfesorListener.class)
public class Profesor extends Persona{
	
	private String departamento;
	private String despacho;
	
	
}
