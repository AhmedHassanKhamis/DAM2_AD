package org.dam2.pruebacontrolador.modelo;

import java.time.LocalDate;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "Comentarios")
@EntityListeners(ComentarioListener.class)
public class Comentario {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	private Usuario autor;
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	private Noticia noticia;
	private LocalDate fecha;
	private String contenido;
	private int valoracion;
	
	
	
	
}
