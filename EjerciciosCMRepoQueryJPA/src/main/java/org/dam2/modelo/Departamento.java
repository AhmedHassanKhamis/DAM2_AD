package org.dam2.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="Departamentos")
public class Departamento {
	@EqualsAndHashCode.Include
	@Id
	@Column(length=4)
	private String codDepto;
	@Column(length=20,nullable = true)
	private String nombreDepto;
	@Column(length=15)
	private String ciudad;
	
	@OneToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
    @JoinColumn(name="codDirector")
	private Empleado codDirector;
	
	@Singular
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER) // Por defecto LAZY
	@JoinColumn(name = "codDepto")
	private List<Empleado> empleados;

}
