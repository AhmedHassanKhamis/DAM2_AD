package org.dam2.pruebacontrolador.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "Noticias")
@EntityListeners(NoticiaListener.class)
public class Noticia {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 100)
	private String titulo;
	private String cuerpo;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	private LocalDate fecha;
	
	@ManyToOne( fetch = FetchType.EAGER)
	private Usuario autor;
	
}
