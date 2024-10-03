package org.dam2.ejercicioTraders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@ToString
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class Transaction {
	private final Trader trader;
	private final int year;
	private final int value;
	
	

	public String toString(){
		return "{" + this.trader + ", " +
				"year: "+this.year+", " +
				"value:" + this.value +"}";
	}
}
