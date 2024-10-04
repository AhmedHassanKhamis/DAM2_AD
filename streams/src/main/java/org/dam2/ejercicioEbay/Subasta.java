package org.dam2.ejercicioEbay;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	private String producto;
	private Usuario propietario;
	private boolean abierto;
	private List<Puja> pujas;

	public Subasta(String producto, Usuario propietario) {
		this.producto = producto;
		this.propietario = propietario;
		this.abierto = true;
		this.pujas = new ArrayList<Puja>();
	}
	
	public boolean pujar(Usuario pujador,int cantidad) {
		if(estaAbierto() && creditoSuficiente(pujador, cantidad) && !esPropietario(pujador)) {
			pujas.add(new Puja(pujador, cantidad, this));
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean pujar(Usuario pujador)  {
		if(estaAbierto() && creditoSuficiente(pujador) && !esPropietario(pujador)) {
			pujas.add(new Puja(pujador, 1, this));
			return true;
		}else {
			return false;
		}
	}
	
	public boolean estaAbierto() {
		return (this.abierto == true)? true : false;
	}
	
	public boolean creditoSuficiente(Usuario pujador,int cantidad){
		return getPujaMayor().get().getCantidad() < cantidad && pujador.getCredito() >= cantidad;
	}
	
	public boolean creditoSuficiente(Usuario pujador){
		return getPujaMayor().get().getCantidad() <  pujador.getCredito();
	}
	
	public boolean esPropietario(Usuario pujador) {
		return this.propietario == pujador; 
	}
	
	
	
	public Optional<Puja> getPujaMayor(){
		return pujas.stream().max((p1,p2) -> p1.getCantidad() - p2.getCantidad());
	}
	
	

}
