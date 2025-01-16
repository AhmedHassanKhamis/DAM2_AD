package org.dam2.modelo;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona {
	
	@EqualsAndHashCode.Include
	@Id
	private String nif;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String poblacion;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "nif_persona")
	@Singular
	private Set<Contacto> contactos;
	

}
