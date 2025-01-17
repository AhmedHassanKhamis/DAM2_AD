package org.dam2.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "DIRECCIONES")
public class Direccion {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 50)
	private String calle;
	@Column(length = 50)
	private String poblacion;
	private int codigoPostal;
	

}
