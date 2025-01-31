package com.example.demo.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cuenta implements Serializable {

	@NonNull
	@EqualsAndHashCode.Include
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private long idCuenta;
	
	@Column (length=20)
	private String ncc;
	
	private float saldo;
	
	
	//Bidireccional
	//@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="cuentas")
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "cuenta_cliente", 
			  joinColumns = @JoinColumn(name = "ncc"), 
			  inverseJoinColumns = @JoinColumn(name = "nif"))
	
	//@OneToMany
	@Singular
	private List<Cliente> clientes = new ArrayList<>();
	

	
	public float totalAvales()
	{
		
		return (float) clientes.stream().mapToDouble(Cliente::getAval).sum();
	}
	
	public void ingresar (float cantidad)
	{
		if (cantidad < 0 )
			cantidad = 0;
		
		saldo += cantidad;
	}
	
	public  boolean retirar (float cantidad)
	{
		boolean exito = true;
		
		if (cantidad < 0)
			cantidad = 0;
		
		if (saldo - cantidad >= maximoNegativo())
			saldo -= cantidad;
		else
			exito = false;
		
		return exito;
	}
	
	public abstract float maximoNegativo();
	public abstract float calcularComision(float cantidad);
	
	public  boolean transferir (float cantidad)
	{
		boolean exito = true;
		float comision ;
		

		if (retirar (cantidad))
		{
			comision = calcularComision(cantidad);
			saldo -= comision;
			
		}
	
		else
			exito = false;
		
		return exito;
	}
	
}
