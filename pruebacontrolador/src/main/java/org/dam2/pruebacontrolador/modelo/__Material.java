package org.dam2.pruebacontrolador.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class __Material implements Serializable{
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column (length=8)
	private String referencia;
	@Column (length=20)
	private String nombre;
	@Column (length=30)
	private String director;
	private LocalDate fechaEstreno;




}