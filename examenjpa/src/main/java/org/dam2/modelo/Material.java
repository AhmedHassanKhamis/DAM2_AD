package org.dam2.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Material {
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 8)
	private String codigoReferencia;
	@Column(length = 20)
	private String nombre;
	@Column(length = 30)
	private String director;
	private LocalDate fechaEstreno;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

}
