package org.dam2.modeloEJ2;


import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Anotaciones Lombok
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Direccion {
	
	private String calle;
	private String poblacion;
	private int codigoPostal;

}
