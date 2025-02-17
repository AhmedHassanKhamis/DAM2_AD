package com.example.demo.modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;




@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


@Entity
public class Contacto implements Serializable {
	@EqualsAndHashCode.Include
	@NonNull
	@Id
	@Column (length=10)
	@NotBlank
	@Pattern(regexp="[0-9]*")
	private String telefono;
	
	@Column (length=20)
	@NotBlank
	private String proveedor;

}
