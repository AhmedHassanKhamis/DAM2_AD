package org.dam2.pruebacontrolador.modelo;

import java.util.List;

import org.hibernate.annotations.Cache;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "noticias")


@Entity
@Table(name = "USUARIOS")
public class Usuario {
	
	@EqualsAndHashCode.Include
	@Id
	@NonNull
	@Column(length = 50)
	private String nickname;
	@Column(length = 50)
	private String password;
	private int puntos = 0;
	
	
	public void addPuntos(int puntos) {
		if (puntos > 0) {
			this.puntos += puntos;
		}
	}
	
}
