package org.dam2.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
@Table(name = "Calificaciones")
@EntityListeners(CalificacionListener.class)

public class Calificacion {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nota")
	private float nota;

	// @MapsId("idmodulo")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_MODULO_ID")
	private Modulo modulo;

	// @MapsId("idalumno")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_ALUMNO_DNI")
	private Alumno alumno;

}
