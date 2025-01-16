package org.dam2.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

@Entity
@EntityListeners(ProfesorListener.class)
public class Profesor extends Persona{

	private String departamento;
	private String despacho;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@Singular
	@JoinColumn(name = "nif_tutor")
	private Set<Estudiante> tutorados;
	
}
