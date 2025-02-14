package com.dam2.examenspring.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "CANCIONES")
public class Cancion {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 50)
	private String titulo;
	@Column(length = 50)
	private String interprete;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	@OneToMany(fetch = FetchType.LAZY)
	@Singular
	private List<Comentario> comentarios;

}
