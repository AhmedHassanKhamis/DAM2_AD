package com.dam2.examenspring.modelo;

import java.time.LocalDate;

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
@Table(name = "USUARIOS")
public class Usuario {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 30)
	private String nickname;
	@Column(length = 30)
	private String contrasenia;
	private LocalDate fechaNacimiento;

}
