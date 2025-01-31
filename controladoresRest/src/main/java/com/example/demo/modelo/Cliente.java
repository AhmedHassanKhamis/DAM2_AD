package com.example.demo.modelo;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder


@Entity
public class Cliente implements Serializable {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column (length=10)
	@NotBlank
	private String nif;
	
	
	@Column (length=10)
	@NotBlank
	@Size(max=10, message="Nombre demasiado largo, use iniciales")
	private String nombre;
	
	@Min(value=1000)
	private float aval;
	
	@Singular
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="FK_NIF")
	Set<Contacto> telefonos;
	
	/* bidireccional
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	List<Cuenta> cuentas;
	*/


}
