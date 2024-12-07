package org.dam2.modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
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
	
	
	@OneToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
    @JoinColumn(name="FK_PROFESOR_DNI")
	private Profesor tutor;
	
	@Singular
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER) // Por defecto LAZY
	@JoinColumn(name = "FK_NOMBRE_GRUPO")
	private List<Alumno> alumnos;

}
