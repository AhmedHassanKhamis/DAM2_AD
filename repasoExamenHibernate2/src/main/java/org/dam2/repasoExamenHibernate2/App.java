package org.dam2.repasoExamenHibernate2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.dam2.modelo.Contacto;
import org.dam2.modelo.Direccion;
import org.dam2.modelo.Estudiante;
import org.dam2.modelo.Instituto;
import org.dam2.modelo.Persona;
import org.dam2.modelo.Profesor;
import org.dam2.modelo.Registro;
import org.dam2.modelo.TipoEstudio;
import org.dam2.utilidadeshibernate.GenericJPADAO;

import daw.com.Teclado;

public class App 
{
	private GenericJPADAO<Instituto, Integer>institutoDAO;
	private GenericJPADAO<Persona, String>personaDAO;
	private GenericJPADAO<Registro, Integer>registroDAO;
	
    public static void main( String[] args )
    {
    	App app = new App();
    	app.inicializar();
    	app.cargarDatos();
//    	app.eliminarProfesor();
//    	app.localizarPersona();
//    	app.convocarTutoria();
//    	app.query1();
    	app.query2();
    	app.query3();
    	
    	
    }

	private void query3() {
		// TODO Auto-generated method stub
		
	}

	private void query2() {
		// TODO Auto-generated method stub
//		String query ="SELECT p from Registro r, Profesor p where r.persona.nif = p.nif and r.instituto.direccion.poblacion != r.persona.poblacion";
		String query ="SELECT r.persona FROM Registro r JOIN r.instituto i JOIN r.persona p WHERE TYPE(p) = Profesor AND i.direccion.poblacion != p.poblacion";

		List<Persona> fueraPoblacion =  personaDAO.executeQuery(query).toList();
		if (fueraPoblacion != null && !fueraPoblacion.isEmpty()) {
			fueraPoblacion.forEach(System.out::println);
		}
	}

	private void query1() {
		// TODO Auto-generated method stub
		String query ="SELECT e from Estudiante e where fechaNacimiento > ?1 and e.tutor = null";
		LocalDate menor = LocalDate.now().minusYears(18);
		List<Estudiante> menoresSinTutor = (List<Estudiante>) personaDAO.executeQuery(query, menor).toList();
		if (menoresSinTutor != null && !menoresSinTutor.isEmpty()) {
			menoresSinTutor.forEach(System.out::println);
		}
		
		
	}

	private void convocarTutoria() {
		// TODO Auto-generated method stub
		String nif = Teclado.leerString("Introduce el nif del profesor a convocar: ");
		Profesor profesor = (Profesor) personaDAO.findById(nif).orElse(null);
		LocalDate fecha = LocalDate.parse(Teclado.leerString("Introduce la fecha de convocatoria(AAAA-mm-dd): "));
		if (profesor != null) {
			String query = "SELECT E FROM Estudiante E where E.tutor = ?1";
			List<Estudiante> convocados = personaDAO.executeQuery(query, profesor).toList();
			if (convocados != null && !convocados.isEmpty()) {
				convocados.stream()
						.forEach(c -> System.out
								.println(c.getNombre() + " quedas convocado/a a la sesión de tutoría en el despacho "
										+ profesor.getDespacho() + " con fecha " + fecha));
			} else {
				System.out.println("EL PROFESOR NO TIENE TUTORANDOS");
			}
		} else {
			System.out.println("NO EXISTE EL PROFESOR!");
		}
	}

	private void localizarPersona() {
		// TODO Auto-generated method stub
		String nif = Teclado.leerString("Introduce el nif de la persona a localizar: ");
		String query = "SELECT P FROM Persona P LEFT JOIN FETCH P.contactos where P.nif = ?1";
		Persona persona = (Persona) personaDAO.executeQuery(query, nif).findFirst().orElse(null);
		if (persona != null) {
			System.out.println(persona.getContactos());

			if (persona instanceof Estudiante) {
				System.out.println("vinculacion de estudiante");
			} else {
				System.out.println("vinculacion de profesor");
			}

		} else {
			System.out.println("NO EXISTE EL PROFESOR!");
		}
	}

	
	
	private void eliminarProfesor() {
		// TODO Auto-generated method stub
		String nif = Teclado.leerString("Introduce el nif del profesor a borrar: ");
		Profesor profesor = (Profesor ) personaDAO.findById(nif).orElse(null);
		if (profesor != null) {
			personaDAO.delete(profesor);
		}else {
			System.out.println("NO EXISTE EL PROFESOR!");
		}

	}

	private void cargarDatos() {
		// TODO Auto-generated method stub
		
		List<Registro> registros = new ArrayList();
		
		
		Contacto contacto1 = Contacto.builder()
				.email("Ahmed@email.com")
				.tipo("Educativo")
				.build();
		
		Contacto contacto2 = Contacto.builder()
				.email("Dylan@email.com")
				.tipo("Educativo")
				.build();
		
		Contacto contacto3 = Contacto.builder()
				.email("Derlys@email.com")
				.tipo("Educativo")
				.build();
		
		Contacto contacto4 = Contacto.builder()
				.email("Peter@email.com")
				.tipo("Educativo")
				.build();
		
		Contacto contacto5 = Contacto.builder()
				.email("Profesor1@email.com")
				.tipo("Laboral")
				.build();
		
		Contacto contacto6 = Contacto.builder()
				.email("Profesor2@email.com")
				.tipo("Laboral")
				.build();
		
		Profesor profesor1 = Profesor.builder()
				.nif("00X")
				.nombre("PROFESOR1")
				.fechaNacimiento(LocalDate.of(1991, 12, 22))
				.poblacion("Rivas")
				.contacto(contacto5)
				.departamento("informatica")
				.despacho("E10")
				.build();
		
		Profesor profesor2 = Profesor.builder()
				.nif("00Z")
				.nombre("PROFESOR2")
				.fechaNacimiento(LocalDate.of(1989, 10, 1))
				.poblacion("Madrid")
				.contacto(contacto6)
				.departamento("desarrollo")
				.despacho("E12")
				.build();
		
		
		Estudiante estudiante1 = Estudiante.builder()
				.nif("00A")
				.nombre("Ahmed")
				.fechaNacimiento(LocalDate.of(2002, 05, 02))
				.poblacion("Madrid")
				.contacto(contacto1)
				.tipoEstudio(TipoEstudio.FPSUPERIOR)
				.grupo("DAM")
				.delegado(false)
				.tutor(profesor1)
				.build();


		Estudiante estudiante2 = Estudiante.builder()
				.nif("00B")
				.nombre("Dylan")
				.fechaNacimiento(LocalDate.of(2013, 12, 03))
				.poblacion("Madrid")
				.contacto(contacto2)
				.tipoEstudio(TipoEstudio.FPSUPERIOR)
				.grupo("DAM")
				.delegado(true)
				.tutor(null)
				.build();
		
		Estudiante estudiante3 = Estudiante.builder()
				.nif("00C")
				.nombre("Derlys")
				.fechaNacimiento(LocalDate.of(2000, 6, 16))
				.poblacion("Vallecas")
				.contacto(contacto3)
				.tipoEstudio(TipoEstudio.BACHILLERATO)
				.grupo("BACH")
				.delegado(false)
				.tutor(profesor2)
				.build();
		
		
		Estudiante estudiante4 = Estudiante.builder()
				.nif("00D")
				.nombre("Peter")
				.fechaNacimiento(LocalDate.of(1000, 9, 10))
				.poblacion("Madrid")
				.contacto(contacto4)
				.tipoEstudio(TipoEstudio.ESO)
				.grupo("ESO")
				.delegado(false)
				.tutor(profesor2)
				.build();
		
		Direccion direccion1 = Direccion.builder()
				.calle("Villablanca")
				.poblacion("LAGALAXIA")
				.codigoPostal(29045)
				.build();
		
		Direccion direccion2 = Direccion.builder()
				.calle("MIBOLA 5")
				.poblacion("LAGALAXIA")
				.codigoPostal(647590)
				.build();
		
		Instituto instituto1 = Instituto.builder()
				.codigoInstituto(10)
				.nombre("Villablanca")
				.telefono(789453349)
				.direccion(direccion1)
				.build();
		
		
		Instituto instituto2 = Instituto.builder()
				.codigoInstituto(20)
				.nombre("Maria Rodrigo")
				.telefono(666666666)
				.direccion(direccion2)
				.build();
		
		
		Registro registro1 = Registro.builder()
				.curso(2)
				.instituto(instituto1)
				.persona(estudiante1)
				.build();
		
		Registro registro2 = Registro.builder()
				.curso(1)
				.instituto(instituto1)
				.persona(estudiante2)
				.build();
		
		Registro registro3 = Registro.builder()
				.curso(2)
				.instituto(instituto1)
				.persona(profesor1)
				.build();
		
		Registro registro4 = Registro.builder()
				.curso(4)
				.instituto(instituto2)
				.persona(estudiante3)
				.build();
		
		Registro registro5 = Registro.builder()
				.curso(1)
				.instituto(instituto2)
				.persona(estudiante4)
				.build();
		
		Registro registro6 = Registro.builder()
				.curso(2)
				.instituto(instituto2)
				.persona(profesor2)
				.build();
		
		registros.addAll(List.of(registro1, registro2, registro3, registro4, registro5, registro6));
		
		registros.stream().forEach(registroDAO::save);
		
		
		
	}

	private void inicializar() {
		// TODO Auto-generated method stub
		institutoDAO = new GenericJPADAO<Instituto, Integer>(Instituto.class,"hibernate");
		personaDAO = new GenericJPADAO<Persona, String>(Persona.class,"hibernate");
		registroDAO = new GenericJPADAO<Registro, Integer>(Registro.class,"hibernate");

	}
}
