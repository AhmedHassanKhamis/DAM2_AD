package org.dam2.modeloEJ2;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

//Anotaciones Lombok
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)


//Anotaciones JPA
@Entity
@EntityListeners(EstudianteListener.class)
public class Estudiante extends Persona {
	
	private int curso;
	private String grupo;
	@Enumerated(EnumType.STRING)
	private Grado grado;
	private boolean delegado;
	
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="nifTutor")
	private Profesor tutor;

}
