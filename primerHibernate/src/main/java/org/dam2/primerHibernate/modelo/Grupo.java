package org.dam2.primerHibernate.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name = "NOMBRE_GRUPO",length = 25)
	private String nombre;
	@Column(name = "TUTOR", length = 45)
	private String tutor;
	@Column(name = "CURSO")
	private int curso;
	

	 @Singular
	 @OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)// Por defecto LAZY
	 @JoinColumn(name="FK_NOMBRE_GRUPO")
	private List<Alumno> alumnos;

}
