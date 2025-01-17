package org.dam2.modelo;

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
@Table(name = "RESIDENCIAS")
public class Residencia {

	@EqualsAndHashCode.Include
	@Id
	private String ip;
	private String calle;
	private int portal;
	private String localidad;
	private int codigoPostal;
	
}
