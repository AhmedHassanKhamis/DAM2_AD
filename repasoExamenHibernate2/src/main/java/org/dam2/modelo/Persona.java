package org.dam2.modelo;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona {

	@EqualsAndHashCode.Include
	@Id
	@Column(length = 10)
	private String nif;
	@Column(length = 50)
	private String nombre;
	private LocalDate fechaNacimiento;
	@Column(length = 50)
	private String poblacion;

	@Singular
	@OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "NIF_PERSONA")
	private Set<Contacto> contactos;
	
	
}
