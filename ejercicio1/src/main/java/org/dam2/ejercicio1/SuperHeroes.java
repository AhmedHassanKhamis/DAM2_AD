package org.dam2.ejercicio1;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)

public class SuperHeroes {
	@XmlTransient
	private String squadName;
	@XmlTransient
	private String homeTown;
	@XmlTransient
	private int formed;
	@XmlTransient
	private SecretBase secretBase;
	@XmlTransient
	private boolean active;
	
	@XmlElement(name = "member")
	private List<Member> members;
	

}
