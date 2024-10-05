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
			System.out.println("El usuario " + pujador.getNombre() +" pujó la cantidad de " + cantidad + " por el articulo -> " + this.producto);
			return true;
		}else {
			System.out.println("la puja no ha podido ser realizada!");
			return false;
		}
	}
	
	
	public boolean pujar(Usuario pujador)  {
		if(estaAbierto() && creditoSuficiente(pujador) && !esPropietario(pujador)) {
			if (!pujas.isEmpty())
				pujas.add(new Puja(pujador,getPujaMayor().get().getCantidad() + 1,this));
			else
				pujas.add(new Puja(pujador, 1, this));
			System.out.println("El usuario " + pujador.getNombre() +" pujó la cantidad de " + getPujaMayor().get().getCantidad() + " por el articulo -> " + this.producto);
			return true;
		}else {
			System.out.println("la puja no ha podido ser realizada!");
			return false;
		}
	}
	
	public boolean ejecutar() {
		if (estaAbierto() && !pujas.isEmpty()) {
			int cantidad = getPujaMayor().get().getCantidad();
			getPropietario().incrementarCredito(cantidad);
			getPujaMayor().get().getPujador().decrementarCredito(cantidad);
			this.propietario = getPujaMayor().get().getPujador();
			this.abierto = false;
			System.out.println("Subasta realizada con exito!");
			System.out.println("El ganador de la subasta es...: "+ getPujaMayor().get().getPujador().getNombre() + "!!!!!!!");
			return true;
		}else {
			System.out.println("La Subasta no se pudo completar!");
			return false;
		}
	}
	
	public boolean estaAbierto() {
		return this.abierto == true;
	}
	
	public boolean creditoSuficiente(Usuario pujador,int cantidad){
		if (!this.pujas.isEmpty())
			return getPujaMayor().get().getCantidad() < cantidad && pujador.getCredito() >= cantidad;
		else
			return  pujador.getCredito() >= cantidad;
	}
	
	public boolean creditoSuficiente(Usuario pujador){
		if (!this.pujas.isEmpty())
			return getPujaMayor().get().getCantidad() <  pujador.getCredito() + 1;
		else
			return pujador.getCredito() >= 1;
	}
	
	public boolean esPropietario(Usuario pujador) {
		return this.propietario == pujador; 
	}
	
	
	
	public Optional<Puja> getPujaMayor(){
		return pujas.stream().max((p1,p2) -> p1.getCantidad() - p2.getCantidad());
	}
	
	

}
