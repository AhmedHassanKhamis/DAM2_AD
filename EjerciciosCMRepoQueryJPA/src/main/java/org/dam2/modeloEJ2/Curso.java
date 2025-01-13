package org.dam2.modeloEJ2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "asignacion_cursos")
public class Curso {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "curso")
	private int curso;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_INSTITUTO_COD")
	private Instituto instituto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_PERSONA_NIF")
	private Estudiante estudiante;
	
}
