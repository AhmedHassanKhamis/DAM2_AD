package org.dam2.ejercicioRefuerzo2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Ciclista extends Deportista{

	
	private String nombrePrueba;
	private int numeroEtapas;
	private int puesto;
	private int etapasGanadas;
	
	
	public Ciclista() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Ciclista(String dni, String nombre, LocalDate fechaNacimiento, String nombrePrueba, int numeroEtapas, int puesto, int etapasGanadas) {
		super(dni, nombre, fechaNacimiento);
		// TODO Auto-generated constructor stub
		this.nombrePrueba = nombrePrueba;
		this.numeroEtapas = numeroEtapas;
		this.puesto = puesto;
		this.etapasGanadas = etapasGanadas;
	}


	public String getNombrePrueba() {
		return nombrePrueba;
	}


	public void setNombrePrueba(String nombrePrueba) {
		this.nombrePrueba = nombrePrueba;
	}


	public int getNumeroEtapas() {
		return numeroEtapas;
	}


	public void setNumeroEtapas(int numeroEtapas) {
		this.numeroEtapas = numeroEtapas;
	}


	public int getPuesto() {
		return puesto;
	}


	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}


	public int getEtapasGanadas() {
		return etapasGanadas;
	}


	public void setEtapasGanadas(int etapasGanadas) {
		this.etapasGanadas = etapasGanadas;
	}


	@Override
	public String toString() {
		return "Ciclista [dni=" + getDni() + ", nombre=" + getNombre() + ", fechaNacimiento=" + getFechaNacimiento() + ", nombrePrueba=" + nombrePrueba + ", numeroEtapas=" + numeroEtapas + ", puesto=" + puesto + ", etapasGanadas=" + etapasGanadas + "]";
	}


	@Override
	public void escribirDeportista (ObjectOutputStream out) {
		// TODO Auto-generated method stub
		try {
			out.writeChar('C');
			out.writeUTF(getDni());
			out.writeUTF(getNombre());
			out.writeUTF(getFechaNacimiento().toString());
			out.writeUTF(nombrePrueba);
			out.writeInt(numeroEtapas);
			out.writeInt(puesto);
			out.writeInt(etapasGanadas);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}


	@Override
	public Deportista leerDeportista(ObjectInputStream in) {
		// TODO Auto-generated method stub
		String dni = null, nombre = null, nombrePrueba = null;
		LocalDate fechaNacimiento = null;
		int numeroEtapas = 0,puesto = 0,etapasGanadas = 0;
		try {
			dni = in.readUTF();
			nombre = in.readUTF();
			fechaNacimiento = LocalDate.parse(in.readUTF());
			nombrePrueba = in.readUTF();
			numeroEtapas = in.readInt();
			puesto = in.readInt();
			etapasGanadas = in.readInt();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return new Ciclista(dni, nombre, fechaNacimiento, nombrePrueba, numeroEtapas, puesto, etapasGanadas);
	}
	
	
	
	
	
	
	
}
