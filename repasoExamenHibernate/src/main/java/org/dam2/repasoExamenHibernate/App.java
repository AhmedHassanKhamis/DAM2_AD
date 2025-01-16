package org.dam2.repasoExamenHibernate;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.dam2.modelo.Contacto;
import org.dam2.modelo.Direccion;
import org.dam2.modelo.Estudiante;
import org.dam2.modelo.Estudio;
import org.dam2.modelo.Instituto;
import org.dam2.modelo.Persona;
import org.dam2.modelo.Profesor;
import org.dam2.modelo.Registro;
import org.dam2.utilidadeshibernate.GenericJPADAO;

/**
 * Hello world!
 *
 */
public class App 
{

	private GenericJPADAO<Persona, Long> personaDAO;
	private GenericJPADAO<Instituto, String> institutoDAO;
	private GenericJPADAO<Registro, Integer> registroDAO;

	
    public static void main( String[] args )
    {
    	App app = new App();
    	
    	app.inicializarDAO();
    	app.cargarDatos();
//    	app.pedirDatos();
    
    
    }


	private void cargarDatos() {
		// TODO Auto-generated method stub
		
//		List<Persona> personas =  new ArrayList<Persona>();
//		List<Instituto> institutos =  new ArrayList<Instituto>();
		List<Registro> registros = new ArrayList<Registro>();
		
		
		Contacto contacto1 = Contacto.builder()
				.email("ahmed@gmail.com")
				.tipo("personal")
				.build();
		
		
		Estudiante estudiante1 = Estudiante.builder()
				.nif("00A")
				.nombre("Ahmed")
				.fechaNacimiento(LocalDate.parse("2002-05-02"))
				.poblacion("Madrid")
				.contacto(contacto1)
				.grupo("DAW")
				.estudio(Estudio.FPSUPERIOR)
				.delegado(false)
				.build();
		
		
		Contacto contacto2 = Contacto.builder()
				.email("angela@yahoo.com")
				.tipo("Educativo")
				.build();
		
		
		Estudiante estudiante2 = Estudiante.builder()
				.nif("00B")
				.nombre("Angela")
				.fechaNacimiento(LocalDate.parse("2002-05-15"))
				.poblacion("Madrid")
				.contacto(contacto2)
				.grupo("AVIACION")
				.estudio(Estudio.FPSUPERIOR)
				.delegado(false)
				.build();
		
		Contacto contacto3 = Contacto.builder()
				.email("profesor1@gmail.com")
				.tipo("Laboral")
				.build();
		
		Profesor profesor1 = Profesor.builder()
				.nif("00C")
				.nombre("profesor1")
				.fechaNacimiento(LocalDate.parse("1982-01-12"))
				.poblacion("Rivas")
				.contacto(contacto3)
				.departamento("informatica")
				.despacho("E10")
				.tutorados(Set.of(estudiante1,estudiante2))
				.build();
		
		
		
		
		Contacto contacto4 = Contacto.builder()
				.email("nacho@hotmail.com")
				.tipo("Educativo")
				.build();
		
		
		Estudiante estudiante3 = Estudiante.builder()
				.nif("00D")
				.nombre("Nacho")
				.fechaNacimiento(LocalDate.parse("2002-05-31"))
				.poblacion("VALDECARROS")
				.contacto(contacto4)
				.grupo("SMR")
				.estudio(Estudio.FPMEDIO)
				.delegado(true)
				.build();
		
		
		Contacto contacto5 = Contacto.builder()
				.email("marlon@yopmail.com")
				.tipo("Educativo")
				.build();
		
		
		Estudiante estudiante4 = Estudiante.builder()
				.nif("00E")
				.nombre("Marlon")
				.fechaNacimiento(LocalDate.parse("2001-09-22"))
				.poblacion("ENSANCHEVK")
				.contacto(contacto5)
				.grupo("MARKETING")
				.estudio(Estudio.FPMEDIO)
				.delegado(false)
				.build();
		
		Contacto contacto6 = Contacto.builder()
				.email("profesor2@gmail.com")
				.tipo("Laboral")
				.build();
		
		Profesor profesor2 = Profesor.builder()
				.nif("00F")
				.nombre("profesor2")
				.fechaNacimiento(LocalDate.parse("1995-08-30"))
				.poblacion("Madrid")
				.contacto(contacto6)
				.departamento("informatica")
				.despacho("E20")
				.tutorados(Set.of(estudiante3,estudiante4))
				.build();
		
		
//		personas.addAll(List.of(estudiante1, estudiante2, estudiante3, estudiante4, profesor1, profesor2));
				
// 		personas.forEach(personaDAO::save);
		
		Direccion direccion1 = Direccion.builder()
				.calle("villablanca1")
				.codPostal(39203)
				.poblacion("Madrid")
				.build();
		
		Instituto instituto1 = Instituto.builder()
				.codigoCentro(1)
				.nombre("villablanca")
				.direccion(direccion1)
				.telefono(606439533)
				.build();
		
		Direccion direccion2 =Direccion.builder()
				.calle("puerto porzuna")
				.codPostal(28031)
				.poblacion("Madrid")
				.build();
		
		Instituto instituto2 = Instituto.builder()
				.codigoCentro(2)
				.nombre("Maria Rodrigo")
				.direccion(direccion2)
				.telefono(387294389)
				.build();
		
//		institutos.addAll(List.of(instituto1,instituto2));
		
//		institutos.forEach(institutoDAO::save);
		
		
		
		Registro registro1 = Registro.builder()
				.Curso(2)
				.persona(estudiante1)
				.instituto(instituto1)
				.build();
		
		Registro registro2 = Registro.builder()
				.Curso(1)
				.persona(estudiante2)
				.instituto(instituto1)
				.build();
		
		Registro registro3 = Registro.builder()
				.Curso(2)
				.persona(profesor1)
				.instituto(instituto1)
				.build();
		
		Registro registro4 = Registro.builder()
				.Curso(1)
				.persona(estudiante3)
				.instituto(instituto2)
				.build();
		
		Registro registro5 = Registro.builder()
				.Curso(2)
				.persona(estudiante4)
				.instituto(instituto2)
				.build();
		
		Registro registro6 = Registro.builder()
				.Curso(1)
				.persona(profesor2)
				.instituto(instituto2)
				.build();
		
		registros.addAll(List.of(registro1, registro2, registro3, registro4, registro5, registro6));
		
		registros.stream().forEach(registroDAO::save);
		
		
	}


	private void inicializarDAO() {
		// TODO Auto-generated method stub
		personaDAO = new GenericJPADAO(Persona.class,"hibernate");
		institutoDAO = new GenericJPADAO(Instituto.class, "hibernate");
		registroDAO = new GenericJPADAO(Registro.class, "hibernate");
	}


	private void pedirDatos() {
		// TODO Auto-generated method stub
		
	}
}
