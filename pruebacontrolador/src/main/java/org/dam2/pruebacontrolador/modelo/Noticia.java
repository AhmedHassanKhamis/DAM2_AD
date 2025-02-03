package org.dam2.pruebacontrolador.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "Noticias")
public class Noticia {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 100)
	private String titulo;
	private String cuerpo;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	private LocalDate fecha;

}
