package org.dam2.ejercicioRefuerzo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TreeMap;

import daw.com.Teclado;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime inicio = LocalDateTime.now();
		
		TreeMap<String, Deportista> deportistas = cargarDeportistas();
		ejecutar(deportistas);
		Duration duracion = Duration.between(inicio, LocalDateTime.now());
		System.out.println("Tiempo utilizado:"+duracion.toHours()+":"+duracion.toMinutes()+":"+duracion.toSeconds());
		
		
	}
	

	public static void ejecutar(TreeMap<String, Deportista> deportistas) {
		int opcion;
		do {
			
			opcion = menu();
			switch (opcion) {
			case 0:
				mostrarDeportistas(deportistas);
				break;
			case 1:
				altaDeportista(deportistas);
				break;
			case 2:
				bajaDeportista(deportistas);
				break;
			case 3:
				edicionDeportista(deportistas);
				break;
			case 4:
				listarPorTipo(deportistas);
				break;
			case 5:
				finalizar(deportistas);
				break;
			}
		} while (opcion != 5);
	}

	
	private static TreeMap<String, Deportista> cargarDeportistas() {
		// TODO Auto-generated method stub
		TreeMap<String,Deportista> deportistas = new TreeMap<String, Deportista>();
		File fichero = new File("deportistas.dat");
		if (fichero.exists()) {
			ObjectInputStream in = null;
			try {
				in = new ObjectInputStream(new FileInputStream(fichero));
				int cantidad = in.readInt();
				if (cantidad > 0) {
				for (int i = 0; i < cantidad; i++) {
					if (in.readChar() == 'A') {
						Atleta deportista = new Atleta();
						deportista = (Atleta) deportista.leerDeportista(in);
						deportistas.put(deportista.getDni(), deportista);
					} else {
						Ciclista deportista  = new Ciclista();
						deportista = (Ciclista) deportista.leerDeportista(in);
						deportistas.put(deportista.getDni(), deportista);
					}
				}
				}else {
					System.out.println("no existen deportistas al momento!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						System.out.println("Error: " + e.getMessage());
						e.printStackTrace();
					}
				}
			}
			
		}else {
			deportistas = new TreeMap<String, Deportista>();
		}
		return deportistas;
		
	}


	private static void finalizar(TreeMap<String, Deportista> deportistas) {
		// TODO Auto-generated method stub
		File fichero = new File("deportistas.dat");
		try {
			final ObjectOutputStream  out = new ObjectOutputStream(new FileOutputStream(fichero));
			out.writeInt(deportistas.size());
			deportistas.entrySet().stream().forEach(d -> d.getValue().escribirDeportista(out));
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("adios!!");
	}


	private static void listarPorTipo(TreeMap<String, Deportista> deportistas) {
		// TODO Auto-generated method stub
		String tipo = Teclado.leerString("Introduce el tipo a listar, Atleta o Ciclista?(A/C)");
		if(tipo.equalsIgnoreCase("A"))
			deportistas.entrySet().stream().filter(d -> d.getValue() instanceof Atleta).sorted((d1, d2) -> d1.getValue().getNombre().compareTo(d2.getValue().getNombre())).forEach(System.out::println);
		else if (tipo.equalsIgnoreCase("C"))
			deportistas.entrySet().stream().filter(d -> d.getValue() instanceof Ciclista).sorted((d1, d2) -> d1.getValue().getNombre().compareTo(d2.getValue().getNombre())).forEach(System.out::println);
		else
			System.out.println("no se reconoce el tipo de deportista introducido");
	}

	
	//####################################################################################################
//		SE TIENE QUE HACER EL CONTROL DE DATOS INTRODUCIDOS
	//####################################################################################################
	private static void edicionDeportista(TreeMap<String, Deportista> deportistas) {
		// TODO Auto-generated method stub
		String dni = Teclado.leerString("Introduce el dni del deportista");
		if(deportistas.containsKey(dni)) {
			String nombre = Teclado.leerString("nombre:");
			LocalDate fechaNacimiento = LocalDate.parse(Teclado.leerString("fecha nacimiento:(AAAA-MM-DD)"));
			String tipo = Teclado.leerString("Es Atleta o Ciclista?(A/C)");
			if(tipo.equalsIgnoreCase("A")) {
				String lugarPrueba = Teclado.leerString("lugar prueba:");
				float metros = Teclado.leerFloat("metros recorridos:");
				LocalTime marca = LocalTime.parse(Teclado.leerString("marca:(HH:MM:SS)"));
				deportistas.put(dni, new Atleta(dni, nombre, fechaNacimiento, lugarPrueba, metros, marca));
				System.out.println("modificado con exito!");
			}else if(tipo.equalsIgnoreCase("C")) {
				String nombrePrueba = Teclado.leerString("nombre prueba:");
				int numeroEtapas = Teclado.leerInt("etapas:");
				int puesto = Teclado.leerInt("puesto:");
				int etapasGanadas = Teclado.leerInt("etapas ganadas:");
				deportistas.put(dni, new Ciclista(dni, nombre, fechaNacimiento, nombrePrueba, numeroEtapas, puesto, etapasGanadas));
				System.out.println("modificado con exito!");
			}else {
				System.out.println("no se reconoce el tipo de deportista introducido");
			}
		}else {
			System.out.println("el dni introducido no existe!");
		}	
	}


	private static void bajaDeportista(TreeMap<String, Deportista> deportistas) {
		// TODO Auto-generated method stub
		String dni = Teclado.leerString("Introduce el dni del deportista");
		if(deportistas.containsKey(dni)) {
			deportistas.remove(dni);
			System.out.println("Deportista eliminado con exito!");
		}else {
			System.out.println("el dni introducido no existe!");
		}	
	}
	
//####################################################################################################
//	SE TIENE QUE HACER EL CONTROL DE DATOS INTRODUCIDOS
//####################################################################################################
	private static void altaDeportista(TreeMap<String, Deportista> deportistas) {
		// TODO Auto-generated method stub
		String dni = Teclado.leerString("Introduce el dni del deportista");
		if(!deportistas.containsKey(dni)) {
			String nombre = Teclado.leerString("nombre:");
			LocalDate fechaNacimiento = LocalDate.parse(Teclado.leerString("fecha nacimiento:(AAAA-MM-DD)"));
			String tipo = Teclado.leerString("Es Atleta o Ciclista?(A/C)");
			if(tipo.equalsIgnoreCase("A")) {
				String lugarPrueba = Teclado.leerString("lugar prueba:");
				float metros = Teclado.leerFloat("metros recorridos:");
				LocalTime marca = LocalTime.parse(Teclado.leerString("marca:(HH:MM:SS)"));
				deportistas.put(dni, new Atleta(dni, nombre, fechaNacimiento, lugarPrueba, metros, marca));
				System.out.println("agregado con exito!");
			}else if(tipo.equalsIgnoreCase("C")) {
				String nombrePrueba = Teclado.leerString("nombre prueba:");
				int numeroEtapas = Teclado.leerInt("etapas:");
				int puesto = Teclado.leerInt("puesto:");
				int etapasGanadas = Teclado.leerInt("etapas ganadas:");
				deportistas.put(dni, new Ciclista(dni, nombre, fechaNacimiento, nombrePrueba, numeroEtapas, puesto, etapasGanadas));
				System.out.println("agregado con exito!");
			}else {
				System.out.println("no se reconoce el tipo de deportista introducido");
			}
		}else {
			System.out.println("el dni introducido ya existe!");
		}	
	}


	private static void mostrarDeportistas(TreeMap<String, Deportista> deportistas) {
		// TODO Auto-generated method stub
		deportistas.entrySet().stream().forEach(System.out::println);
	}


	public static int menu() {
		int opcion;
		do {
			System.out.println("---------MENU--------");
			System.out.println("0.mostrar deportistas");
			System.out.println("1.Dar alta a un deportista");
			System.out.println("2.Dar de baja a un deportista");
			System.out.println("3.Edicion de un deportista");
			System.out.println("4.Listar deportistas por tipo");
			System.out.println("5.abandonar programa");
			opcion = Teclado.leerInt("introduce el numero de una opcion:(0-5)");
			if (opcion < 0 || opcion > 5)
				System.out.println("Opcion incorrecta!!");
		} while (opcion < 0 || opcion > 5);
		return opcion;
	}

}
