package org.dam2.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int idContacto;
	@Column(length = 40)
	private String email;
	@Column(length = 20)
	private String tipo;

	

}
