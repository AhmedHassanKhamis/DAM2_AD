package org.dam2.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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
public class Estudiante extends Persona {

	@Enumerated(EnumType.STRING)
	private TipoEstudio tipoEstudio;
	@Column(length = 20)
	private String grupo;
	private boolean delegado;
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	private Profesor tutor;
	
}
