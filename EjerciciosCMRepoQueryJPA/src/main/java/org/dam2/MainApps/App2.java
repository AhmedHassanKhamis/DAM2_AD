package org.dam2.MainApps;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.dam2.modeloEJ2.Contacto;
import org.dam2.modeloEJ2.Direccion;
import org.dam2.modeloEJ2.Estudiante;
import org.dam2.modeloEJ2.Grado;
import org.dam2.modeloEJ2.Instituto;
import org.dam2.modeloEJ2.Persona;
import org.dam2.modeloEJ2.Profesor;
import org.dam2.utilidadeshibernate.GenericJPADAO;

public class App2 {

	private GenericJPADAO<Persona, Long> personaDAO;
	private GenericJPADAO<Instituto, String> institutoDAO;

	public static void main(String[] args) {
		App2 app = new App2();

		app.Inicializar();
		app.CargarDatos();
//		app.eliminarProfesor();
//		app.localizarPersona();
//		app.convocarSesionTutoria();
//		app.mostrarAlumnosMenoresSinTutor();
//		app.listarProfesoresFueraPoblacion();
		app.listarProfesoresSinTutorandos();

	}
	
	private void eliminarProfesor() {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del profesor a eliminar: ");
        Long profesorId = scanner.nextLong();
        Profesor profesor = (Profesor) personaDAO.findById(profesorId).orElse(null);
        System.out.println(profesor.getNombre());
        if (profesor != null) {
        	personaDAO.delete(profesor);
            System.out.println("Profesor eliminado exitosamente.");
        } else {
            System.out.println("Profesor no encontrado.");
        }

	}

	private void localizarPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el NIF de la persona a localizar: ");
        Long nif = scanner.nextLong();

        Optional<Persona> persona = personaDAO.findById(nif);
        if (persona.isPresent()) {
            Persona p = persona.get();
            System.out.println("Persona encontrada: " + p.getNombre());
            System.out.println("Emails de contacto: " + p.getContactos());
            if (p instanceof Profesor) {
                System.out.println("Vinculación: Profesor");
            } else if (p instanceof Estudiante) {
                System.out.println("Vinculación: Estudiante");
            }
        } else {
            System.out.println("Persona no encontrada.");
        }
        scanner.close();
    }


	private void convocarSesionTutoria() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Ingrese el NIF del profesor: ");
	    Long nifProfesor = scanner.nextLong();
	    scanner.nextLine(); // Consumir la nueva línea
	    System.out.print("Ingrese la fecha de la sesión de tutoría (dd/MM/yyyy): ");
	    String fechaTutoria = scanner.nextLine();
	
	    Optional<Persona> persona = personaDAO.findById(nifProfesor);
	    if (persona.isPresent() && persona.get() instanceof Profesor) {
	        Profesor profesor = (Profesor) persona.get();
			String query = "SELECT e from Estudiante e where tutor = ?1";
	        List<Estudiante> tutorandos = personaDAO.executeQuery(query,profesor).toList();
	        if (tutorandos.isEmpty()) {
	            System.out.println("El profesor no tiene tutorandos.");
	        } else {
	            for (Estudiante tutorando : tutorandos) {
	                System.out.println(tutorando.getNombre() + " quedas convocado/a a la sesión de tutoría en el despacho " + profesor.getDespacho() + " con fecha " + fechaTutoria);
	            }
	        }
	    } else {
	        System.out.println("Profesor no encontrado.");
	    }
	    scanner.close();
	}



	private void mostrarAlumnosMenoresSinTutor() {
		// Implementar la lógica para mostrar alumnos menores de edad sin tutor asignado
		String query = "SELECT e from Estudiante e where fechaNacimiento > ?1 and tutor = null";
       	personaDAO.executeQuery(query,LocalDate.now().minusYears(18)).forEach(System.out::println);;

	}

	private void listarProfesoresFueraPoblacion() {
		// Implementar la lógica para listar profesores que residen fuera de la población del instituto
		String query = "SELECT p FROM Instituto i LEFT JOIN i.profesores p WHERE p.poblacion != i.direccion.poblacion";
		institutoDAO.executeQuery(query).forEach(System.out::println);

	}

	private void listarProfesoresSinTutorandos() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el nombre del departamento: ");
		String departamento = scanner.nextLine();
	
		String query = "SELECT p FROM Profesor p WHERE p.departamento = ?1 AND p NOT IN (SELECT DISTINCT e.tutor FROM Estudiante e WHERE e.tutor IS NOT NULL)";
		List<Profesor> profesoresSinTutorandos = personaDAO.executeQuery(query,departamento).toList();
	
		if (profesoresSinTutorandos.isEmpty()) {
			System.out.println("No hay profesores sin tutorandos en el departamento " + departamento);
		} else {
			profesoresSinTutorandos.forEach(profesor -> System.out.println(profesor.getNombre()));
		}
		scanner.close();
	}
	
	private void CargarDatos() {
		List<Instituto> institutos = new ArrayList<Instituto>();
		
		Direccion direccion1 = Direccion.builder()
				.calle("ballestrinki")
				.poblacion("España")
				.codigoPostal(28051)
				.build();
		
		Contacto contacto1 = Contacto.builder()
				.Tipo("personal")
				.email("email.email@email.com")
				.build();
		
		Contacto contacto2 = Contacto.builder()
				.Tipo("Trabajo")
				.email("email.email@email.com")
				.build();

		
		Profesor profesor1 = Profesor.builder()
				.nombre("Rosa")
				.fechaNacimiento(LocalDate.of(1994, 01, 17))
				.poblacion("España")
				.contacto(contacto2)
				.departamento("Informatica")
				.despacho("des109")
				.build();
		
		
		Estudiante estudiante1 = Estudiante.builder()
				.nombre("ahmed")
				.fechaNacimiento(LocalDate.of(2002, 05, 2))
				.poblacion("España")
				.contacto(contacto1)
				.curso(2)
				.grupo("ASIR")
				.grado(Grado.FPSUPERIOR)
				.delegado(false)
				.tutor(profesor1)
				.build();
		
		Estudiante estudianteextra = Estudiante.builder()
				.nombre("Angela")
				.fechaNacimiento(LocalDate.of(2013, 05, 2))
				.poblacion("España")
				.contacto(contacto1)
				.curso(2)
				.grupo("ASIR")
				.grado(Grado.FPSUPERIOR)
				.delegado(false)
				.tutor(profesor1)
				.build();
		
		Instituto instituto = Instituto.builder()
				.codigo("A001")
				.nombre("Villablanca")
				.telefono(502312321)
				.direccion(direccion1)
				.estudiantes(List.of(estudiante1,estudianteextra))
				.profesore(profesor1)
				.build();
		
		Direccion direccion2 = Direccion.builder()
				.calle("calle falsa")
				.poblacion("Madrid")
				.codigoPostal(28001)
				.build();
		
		Contacto contacto3 = Contacto.builder()
				.Tipo("personal")
				.email("juan.email@email.com")
				.build();
		
		Contacto contacto4 = Contacto.builder()
				.Tipo("Trabajo")
				.email("juan.trabajo@email.com")
				.build();
		
		
		
		Profesor profesor2 = Profesor.builder()
				.nombre("Carlos")
				.fechaNacimiento(LocalDate.of(1985, 03, 22))
				.poblacion("MAYORCA")
				.contacto(contacto4)
				.departamento("Matematicas")
				.despacho("des110")
				.build();
		
		Estudiante estudiante2 = Estudiante.builder()
				.nombre("Juan")
				.fechaNacimiento(LocalDate.of(2003, 06, 15))
				.poblacion("Madrid")
				.contacto(contacto3)
				.curso(1)
				.grupo("DAM")
				.grado(Grado.FPSUPERIOR)
				.delegado(true)
				.tutor(profesor2)
				.build();
		
		Instituto instituto2 = Instituto.builder()
				.codigo("A002")
				.nombre("Instituto Central")
				.telefono(601234567)
				.direccion(direccion2)
				.estudiante(estudiante2)
				.profesore(profesor2)
				.build();
		
		
		Direccion direccion3 = Direccion.builder()
			.calle("avenida siempre viva")
			.poblacion("Barcelona")
			.codigoPostal(003)
			.build();

		Contacto contacto5 = Contacto.builder()
			.Tipo("personal")
			.email("maria.email@email.com")
			.build();

		Contacto contacto6 = Contacto.builder()
			.Tipo("Trabajo")
			.email("maria.trabajo@email.com")
			.build();


		Profesor profesor3 = Profesor.builder()
			.nombre("Ana")
			.fechaNacimiento(LocalDate.of(1990, 11, 30))
			.poblacion("Barcelona")
			.contacto(contacto6)
			.departamento("Lenguas")
			.despacho("des111")
			.build();
		

		Estudiante estudiante3 = Estudiante.builder()
			.nombre("Maria")
			.fechaNacimiento(LocalDate.of(2004, 07, 20))
			.poblacion("Barcelona")
			.contacto(contacto5)
			.curso(1)
			.grupo("DAW")
			.grado(Grado.FPSUPERIOR)
			.delegado(false)
			.tutor(profesor3)
			.build();

		Instituto instituto3 = Instituto.builder()
			.codigo("A003")
			.nombre("Instituto Norte")
			.telefono(701234567)
			.direccion(direccion3)
			.estudiante(estudiante3)
			.profesore(profesor3)
			.build();

		institutos.add(instituto3);
		institutos.add(instituto2);


		institutos.add(instituto);
		
		institutos.forEach(institutoDAO::save);
		
		
		
	}


	public void Inicializar() {
		institutoDAO = new GenericJPADAO (Instituto.class,"hibernate");
		personaDAO = new GenericJPADAO (Persona.class,"hibernate");
    }
	

}
