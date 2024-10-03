package org.dam2.ejercicioEbay;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder
@Data
@RequiredArgsConstructor
@Setter(value = AccessLevel.NONE )
public class Puja {

	private final Usuario pujador;
	private final int cantidad;
	private final Subasta subasta;
		
	
}
