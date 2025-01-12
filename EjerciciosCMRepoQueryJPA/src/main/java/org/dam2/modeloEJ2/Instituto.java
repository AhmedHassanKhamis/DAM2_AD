package org.dam2.modeloEJ2;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name="Institutos")
public class Instituto {
	@EqualsAndHashCode.Include
	@Id
	private String codigo;
	private String nombre;
	private int telefono;
	
	@Embedded
	private Direccion direccion;
	
//	@Singular
//	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY) // Por defecto LAZY
//	@JoinColumn(name = "codigoInstituto")
//	private List<Estudiante> estudiantes;
//	
//	@Singular
//	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY) // Por defecto LAZY
//	@JoinColumn(name = "codigoInstituto")
//	private List<Profesor> profesores;
	
	@Singular
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY) // Por defecto LAZY
//	@JoinColumn(name = "codigoInstituto")
	private List<Persona> personas;

	

}
