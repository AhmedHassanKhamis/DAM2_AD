package org.dam2.empledepart.modelo;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;



import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@Entity
public class Depart {
	/*
	 codDepto varchar (4) PRIMARY KEY,
	nombreDpto varchar (20) NOT NULL,
	ciudad varchar (15),
	codDirector varchar (12)
	 */
	
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column (name="coddepto",length=4,nullable=false)
	private String codDepto;
	
	@NonNull
	@Column (name ="nombredepto",length=20,nullable=false)
	private String nombreDepto;
	
	@NonNull
	@Column (length=25,nullable=false)
	private String ciudad;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "coddirector", nullable = true)
	private Emple director;


	@Override
	public String toString() {
		return "Depart [codDepto=" + codDepto + ", nombreDepto=" + nombreDepto + ", ciudad=" + ciudad + ", director="
				+ director.getNidemp() + "]";
	}
	
	

}
