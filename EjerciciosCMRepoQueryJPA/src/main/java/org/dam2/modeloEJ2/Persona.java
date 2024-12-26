package org.dam2.modeloEJ2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

//Anotaciones Lombok
@SuperBuilder 
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
abstract public class Persona implements Serializable{
	@EqualsAndHashCode.Include
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long nif;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String poblacion;
	
	@Singular
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER) // Por defecto LAZY
	@JoinColumn(name = "nifPersona")
	private List<Contacto> contactos;

}
