package org.dam2.primerHibernate.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "GRUPOS")
public class Grupo {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "NOMBRE_GRUPO")
	private String nombre;
	@Column(name = "TUTOR")
	private String tutor;
	@Column(name = "CURSO")
	private int curso;
	private List<Alumno> alumnos;

}
