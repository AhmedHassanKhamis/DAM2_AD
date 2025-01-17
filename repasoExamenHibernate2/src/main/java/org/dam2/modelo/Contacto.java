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
@Table(name = "CONTACTOS")
public class Contacto {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 100)
	private String email;
	@Column(length = 30)
	private String tipo;

}
