package org.dam2.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="Alumnos")
public class Alumno implements Serializable {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name = "nombre")
	private String nombre;
    
	@OneToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
    @JoinColumn(name="idDireccion")
	private Direccion direccion;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="FK_NOMBRE_GRUPO")
    private Grupo grupo;
	

}
