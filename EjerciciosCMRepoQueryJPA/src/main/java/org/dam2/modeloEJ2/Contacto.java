package org.dam2.modeloEJ2;

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

//Anotaciones Lombok
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

//Anotaciones JPA
@Entity
@Table(name="Contactos")
public class Contacto {
	
	@EqualsAndHashCode.Include
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Tipo;
	private String email;

}
