package org.dam2.ejercicioEbay;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@AllArgsConstructor
@Data
@Builder
@Setter(value = AccessLevel.NONE )
public class Subasta {
	
	private String nombreProducto;
	private Usuario propietario;
	private boolean abierto;
	private List<Puja> pujas;

	
	
	public optional<

}
