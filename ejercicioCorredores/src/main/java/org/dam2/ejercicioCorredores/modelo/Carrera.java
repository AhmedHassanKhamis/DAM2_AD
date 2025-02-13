package org.dam2.ejercicioCorredores.modelo;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "CARRERAS")
public class Carrera {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 50)
	private String nombreCarrera;
	private int cupo;
	private LocalDate fechaCelebracion;
	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<PuntoDeControl> puntosDeControl;

}
