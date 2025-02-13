package org.dam2.ejercicioCorredores.modelo;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "CORREDORES")
public class Corredor {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 10)
	@NonNull
	private String dni;
	
	@Column(length = 50)
	private String nombreCorredor;
	
	private boolean sexo;
	

}
