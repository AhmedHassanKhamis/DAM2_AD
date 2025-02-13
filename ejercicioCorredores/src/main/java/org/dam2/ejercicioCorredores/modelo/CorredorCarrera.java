package org.dam2.ejercicioCorredores.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "CORREDORCARRERAS")
public class CorredorCarrera {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int tiempo;
	private int dorsal;
	@ManyToOne(fetch = FetchType.EAGER)
	private Corredor corredor;
	@ManyToOne(fetch = FetchType.EAGER)
	private Carrera carrera;
	
	
	public String tiempoHorasMinutosSegundos() {
	    int horas = tiempo / 3600;
	    int minutos = (tiempo % 3600) / 60;
	    int segundos = (tiempo % 3600) % 60;
	    
	    return String.format("%02d:%02d:%02d", horas, minutos, segundos);
	}
	
	
//	corredor -> 
//	select c.dni from Corredor where c.dni = "VARIABLE1"
//	------------------------------------------------------------
//	corredorCarrera ->
//	select count(pito)+1 from CorredorCarrera pito where pito.carrera.nombreCarrera = "variable"
//	select max(p.dorsal)+1 from CorredorCarrera p where p.carrera.nombreCarrera = "variable" 
//
//
//	select p from CorredorCarrera p where p.carrera.nombreCarrera = "variable"
//
//
//	select c.corredor.nombre,c.corredor.dni,c.tiempo from CorredorCarrera c where c.carrera.fechaCelebracion = (select Min(j.fechaCelebracion) from Carrera j ) order by c.tiempo
//
//	SELECT MIN(FECHACELEBRACION) FROM CARRERAS
//
//	------------------------------------------------------------
//	carrera -> 
//	select c.nombreCarrera From Carrera c where c.cupo > (select count(p) from CorredorCarrera p where p.carrera = c) AND c.nombreCarrera not in (select p.carrera.nombreCarrera from CorredorCarrera p where p.corredor = "VARIABLE2")
//


}
