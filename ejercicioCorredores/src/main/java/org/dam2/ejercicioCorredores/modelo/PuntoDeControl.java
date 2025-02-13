package org.dam2.ejercicioCorredores.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "PUNTOSDECONTROL")
public class PuntoDeControl {
	
	@EqualsAndHashCode.Include
	@Id
	private float km;
	@Column(length = 30)
	private String juez;
	private int tiempo;
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	private Corredor primerCorredor;
	
	public String tiempoHorasMinutosSegundos() {
	    int horas = tiempo / 3600;
	    int minutos = (tiempo % 3600) / 60;
	    int segundos = (tiempo % 3600) % 60;
	    
	    return String.format("%02d:%02d:%02d", horas, minutos, segundos);
	}
}
