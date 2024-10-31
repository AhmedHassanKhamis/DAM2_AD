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
	private TreeMap<String, Deportista> deportistas;

	public App() {
		this.deportistas = new TreeMap<String, Deportista>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime inicio = LocalDateTime.now();
		App app = new App();
		app.cargarDeportistas();
		app.ejecutar();

		Duration duracion = Duration.between(inicio, LocalDateTime.now());
		System.out.println(
				"Tiempo utilizado:" + duracion.toHours() + ":" + duracion.toMinutes() + ":" + duracion.toSeconds());

	}

	private void ejecutar() {
		int opcion;
		do {
			opcion = menu();
			switch (opcion) {
			case 0:
				mostrarDeportistas();
				break;
			case 1:
				altaDeportista();
				break;
			case 2:
				bajaDeportista();
				break;
			case 3:
				edicionDeportista();
				break;
			case 4:
				listarPorTipo();
				break;
			case 5:
				finalizar();
				break;
			}
		} while (opcion != 5);
	}

	private void cargarDeportistas() {
		// TODO Auto-generated method stub
		TreeMap<String, Deportista> deportistas = new TreeMap<String, Deportista>();
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
							deportista.leerDeportista(in);
							deportistas.put(deportista.getDni(), deportista);
						} else {
							Ciclista deportista = new Ciclista();
							deportista.leerDeportista(in);
							deportistas.put(deportista.getDni(), deportista);
						}
					}
				} else {
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

		} else {
			deportistas = new TreeMap<String, Deportista>();
		}
		this.deportistas = deportistas;

	}

	private void finalizar() {
		// TODO Auto-generated method stub
		File fichero = new File("deportistas.dat");
		try {
			final ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichero));
			out.writeInt(deportistas.size());
//			deportistas.entrySet().stream().forEach(d -> d.getValue().escribirDeportista(out));
			for (Deportista deportista : deportistas.values()) {
				if (deportista instanceof Atleta) {
					out.writeChar('A');
				} else {
					out.writeChar('C');
				}
				deportista.escribirDeportista(out);
			}
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

	private void listarPorTipo() {
		// TODO Auto-generated method stub
		String tipo = Teclado.leerString("Introduce el tipo a listar, Atleta o Ciclista?(A/C)");
		if (tipo.equalsIgnoreCase("A"))
			deportistas.entrySet().stream().filter(d -> d.getValue() instanceof Atleta)
					.sorted((d1, d2) -> d1.getValue().getNombre().compareTo(d2.getValue().getNombre()))
					.forEach(System.out::println);
		else if (tipo.equalsIgnoreCase("C"))
			deportistas.entrySet().stream().filter(d -> d.getValue() instanceof Ciclista)
					.sorted((d1, d2) -> d1.getValue().getNombre().compareTo(d2.getValue().getNombre()))
					.forEach(System.out::println);
		else
			System.out.println("no se reconoce el tipo de deportista introducido");
	}

	// ####################################################################################################
//		SE TIENE QUE HACER EL CONTROL DE DATOS INTRODUCIDOS
	// ####################################################################################################
	private void edicionDeportista() {
		// TODO Auto-generated method stub
		String dni = Teclado.leerString("Introduce el dni del deportista");
		if (deportistas.containsKey(dni)) {
			String nombre = Teclado.leerString("nombre:");
			LocalDate fechaNacimiento = LocalDate.parse(Teclado.leerString("fecha nacimiento:(AAAA-MM-DD)"));
			String tipo = Teclado.leerString("Es Atleta o Ciclista?(A/C)");
			if (tipo.equalsIgnoreCase("A")) {
				String lugarPrueba = Teclado.leerString("lugar prueba:");
				float metros = Teclado.leerFloat("metros recorridos:");
				LocalTime marca = LocalTime.parse(Teclado.leerString("marca:(HH:MM:SS)"));
				deportistas.put(dni, new Atleta(dni, nombre, fechaNacimiento, lugarPrueba, metros, marca));
				System.out.println("modificado con exito!");
			} else if (tipo.equalsIgnoreCase("C")) {
				String nombrePrueba = Teclado.leerString("nombre prueba:");
				int numeroEtapas = Teclado.leerInt("etapas:");
				int puesto = Teclado.leerInt("puesto:");
				int etapasGanadas = Teclado.leerInt("etapas ganadas:");
				deportistas.put(dni,
						new Ciclista(dni, nombre, fechaNacimiento, nombrePrueba, numeroEtapas, puesto, etapasGanadas));
				System.out.println("modificado con exito!");
			} else {
				System.out.println("no se reconoce el tipo de deportista introducido");
			}
		} else {
			System.out.println("el dni introducido no existe!");
		}
	}

	private void bajaDeportista() {
		// TODO Auto-generated method stub
		String dni = Teclado.leerString("Introduce el dni del deportista");
		if (deportistas.containsKey(dni)) {
			deportistas.remove(dni);
			System.out.println("Deportista eliminado con exito!");
		} else {
			System.out.println("el dni introducido no existe!");
		}
	}

//####################################################################################################
//	SE TIENE QUE HACER EL CONTROL DE DATOS INTRODUCIDOS
//####################################################################################################
	private void altaDeportista() {
		// TODO Auto-generated method stub
		String dni = Teclado.leerString("Introduce el dni del deportista");
		if (!deportistas.containsKey(dni)) {
			String nombre = Teclado.leerString("nombre:");
			LocalDate fechaNacimiento = LocalDate.parse(Teclado.leerString("fecha nacimiento:(AAAA-MM-DD)"));
			String tipo = Teclado.leerString("Es Atleta o Ciclista?(A/C)");
			if (tipo.equalsIgnoreCase("A")) {
				String lugarPrueba = Teclado.leerString("lugar prueba:");
				float metros = Teclado.leerFloat("metros recorridos:");
				LocalTime marca = LocalTime.parse(Teclado.leerString("marca:(HH:MM:SS)"));
				deportistas.put(dni, new Atleta(dni, nombre, fechaNacimiento, lugarPrueba, metros, marca));
				System.out.println("agregado con exito!");
			} else if (tipo.equalsIgnoreCase("C")) {
				String nombrePrueba = Teclado.leerString("nombre prueba:");
				int numeroEtapas = Teclado.leerInt("etapas:");
				int puesto = Teclado.leerInt("puesto:");
				int etapasGanadas = Teclado.leerInt("etapas ganadas:");
				deportistas.put(dni,
						new Ciclista(dni, nombre, fechaNacimiento, nombrePrueba, numeroEtapas, puesto, etapasGanadas));
				System.out.println("agregado con exito!");
			} else {
				System.out.println("no se reconoce el tipo de deportista introducido");
			}
		} else {
			System.out.println("el dni introducido ya existe!");
		}
	}

	private void mostrarDeportistas() {
		// TODO Auto-generated method stub
		deportistas.entrySet().stream().forEach(System.out::println);
	}

	private int menu() {
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
