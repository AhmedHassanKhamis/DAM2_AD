package org.dam2.ejercicioTraders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class Trader {
	private final String name;
	private final String city;
}
