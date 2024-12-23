package org.dam2.modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "Empleados")
public class Empleado {
	@EqualsAndHashCode.Include
	@Id
	@Column(length=12,nullable = true)
	private String nIDEmp;
	@Column(length=30,nullable = true)
	private String nomEmp;
	@Enumerated(EnumType.STRING)
	@Column(nullable = true,length = 1)
	private Sexo sexEmp;
	@Column(nullable = true)
	private LocalDate fecNac;
	@Column(nullable = true)
	private LocalDate fecIncorporacion;
	@Column(nullable = true)
	private float salEmp;
	@Column(nullable = true)
	private float comisionE;
	@Column(length = 15, nullable = true)
	private String cargoE;
	@OneToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
    @JoinColumn(name="jefeID")
	private Empleado jefe;
}
