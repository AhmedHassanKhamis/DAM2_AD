package com.dam2.examenspring.modelo;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "REPRODUCCIONES")
public class Reproduccion {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int idReproduccion;
	private LocalDateTime fechaReproduccion;
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;
	@ManyToOne(fetch = FetchType.EAGER)
	private Cancion cancion;

}
