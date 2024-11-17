package org.dam2.grupoAlumnos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.dam2.grupoAlumnos.controladores.AlumnoControlador;
import org.dam2.grupoAlumnos.controladores.Controlador;
import org.dam2.grupoAlumnos.controladores.GrupoControlador;
import org.dam2.grupoAlumnos.dao.AlumnoDAO;
import org.dam2.grupoAlumnos.dao.DAOInterface;
import org.dam2.grupoAlumnos.dao.GrupoDAO;
import org.dam2.grupoAlumnos.modelo.Alumno;
import org.dam2.grupoAlumnos.modelo.Grupo;

import daw.com.Teclado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class App {
	
	private static HashMap<String,Grupo> grupos = new HashMap<String,Grupo>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App();
		app.cargarGrupos();
		System.out.println(grupos);
//		System.out.println("primer grupo:");
//		app.crearGrupo();
//		System.out.println("segundo grupo:");
//		app.crearGrupo();
//		System.out.println("Grupo solicitado:");
//		app.mostrarGrupo("DAW2");
//		System.out.println("primer alumno:");
//		app.crearAlumno();
//		System.out.println("segundo alumno:");
//		app.crearAlumno();
//		System.out.println("tercer alumno:");
//		app.crearAlumno();
//		app.borrarAlumno();
		app.borrarGrupo();
		
		
		
		
		

	}
	
	public void mostrarGrupo(String nombre) {
		DAOInterface<Grupo, String> dao = new GrupoDAO();
		Grupo grupo = dao.findById(nombre).orElse(new Grupo());
		if(grupo != null)
			System.out.println(grupo);
		else
			System.err.println("Grupo no encontrado");
	}
	
	public void crearGrupo() {
		Controlador<Grupo> grupoControlador = new GrupoControlador(new Grupo());
		grupoControlador.leerClave();
		grupoControlador.leerRestoDatos();
		grupos.put(grupoControlador.getModelo().getNombre(),grupoControlador.getModelo());
		DAOInterface<Grupo, String>dao = new GrupoDAO();
		if (dao.save(grupoControlador.getModelo()) > 0) {
			System.out.println("Grupo agregado con exito");
		}else {
			System.out.println("No se pudo agregar el grupo");
		}
		
		
	}
	
	public void crearAlumno() {
		Controlador<Alumno> alumnoControlador = new AlumnoControlador(new Alumno());
		alumnoControlador.leerClave();
		alumnoControlador.leerRestoDatos();
		AlumnoDAO dao = new AlumnoDAO();

		if (dao.save(alumnoControlador.getModelo()) > 0) {
			System.out.println("Alumno agregado con exito");
			if (Teclado.leerString("Agregar el alumno a un grupo?(si/no)").equalsIgnoreCase("si")) {
				String nombreGrupo = Teclado.leerString("nombre del grupo a agregar");
				Grupo grupoObjetivo = grupos.values().stream().filter(grupo -> grupo.getNombre().equalsIgnoreCase(nombreGrupo)).findFirst().orElse(new Grupo());
				grupoObjetivo.getAlumnos().add(alumnoControlador.getModelo());
				grupos.put(nombreGrupo, grupoObjetivo);
				dao.update(alumnoControlador.getModelo(),nombreGrupo);				
			}
		}else {
			System.out.println("No se pudo agregar el Alumno");
		}	
	}
	
	public void cambiarAlummnoCurso() {
		AlumnoDAO dao = new AlumnoDAO();
		Controlador<Alumno> alumnoControlador = new AlumnoControlador(new Alumno());
		alumnoControlador.leerClave();
		alumnoControlador.setModelo(dao.findById(Teclado.leerString("nia del alumno a cambiar de grupo")).get());
		String nombreGrupo = Teclado.leerString("nombre del grupo a agregar");
		Grupo grupoObjetivo = grupos.values().stream().filter(grupo -> grupo.getNombre().equalsIgnoreCase(nombreGrupo)).findFirst().get();
		if (grupoObjetivo != null) {
			grupoObjetivo.getAlumnos().add(alumnoControlador.getModelo());
			grupos.put(nombreGrupo, grupoObjetivo);
			dao.update(alumnoControlador.getModelo(),nombreGrupo);		
		} else {
			System.out.println("El grupo no existe!");
		}
	}
	
	public void borrarAlumno() {
		AlumnoDAO dao = new AlumnoDAO();
		Controlador<Alumno> alumnoControlador = new AlumnoControlador(new Alumno());
		alumnoControlador.setModelo(dao.findById(Teclado.leerString("nia del alumno a borrar")).orElse(new Alumno()));
		dao.delete(alumnoControlador.getModelo());
	}
	
	public void borrarGrupo() {
		DAOInterface<Grupo, String> dao = new GrupoDAO();
		Controlador<Grupo> grupoControlador = new GrupoControlador(new Grupo());
		grupoControlador.setModelo(dao.findById(Teclado.leerString("Nombre del Grupo a borrar")).orElse(new Grupo()));
		dao.delete(grupoControlador.getModelo());
	}
	
	public void cargarGrupos(){
		DAOInterface<Grupo, String> dao = new GrupoDAO(); 
		dao.findAll().forEach(grupo -> grupos.put(grupo.getNombre(), grupo));
	}

	
}
