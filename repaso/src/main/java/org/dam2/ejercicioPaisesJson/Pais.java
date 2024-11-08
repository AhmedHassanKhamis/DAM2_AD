package org.dam2.ejercicioPaisesJson;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pais {
	
	@EqualsAndHashCode.Include
	private String nombre;
	private Continente continente;
	private String capital;
	private String textoCapital;
	private List<String> ciudadImportante;

}
