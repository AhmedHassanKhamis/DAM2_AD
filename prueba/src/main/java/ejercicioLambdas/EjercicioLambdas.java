package ejercicioLambdas;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import daw.com.Pantalla;
import daw.com.Teclado;

public class EjercicioLambdas {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Consumer<Object> ESCRIBIDOR = System.out::println;
		List <Alumno> alumnos;
		Comparator<Alumno> comparador1,comparador2, comparador3, comparador4;
		Predicate <Alumno> predicado1, predicado2;
		Set<String> cursos;
		String curso;

		// Cargar alumnos
		alumnos = cargarAlumnos ();
		
		System.out.println("listado de alumnos cargados");
		alumnos.forEach(ESCRIBIDOR);
		
		// ordenar por nombre
		comparador1 = (a,b) -> a.getNombre().compareToIgnoreCase(b.getNombre());
		alumnos.sort(comparador1);
		
		// ordenar por nombre inverso
		alumnos.sort(comparador1.reversed());
		
		// ordenar por fecha y nombre
		comparador2 = (a,b) -> a.getFecha().compareTo(b.getFecha());
		
		alumnos.sort(comparador2.thenComparing(comparador1));
		
		// ordenar por curso y nota
		comparador4 = (a,b) -> a.getCurso().compareToIgnoreCase(b.getCurso());
		comparador3 = (a,b) -> Float.compare(a.getNota(), b.getNota());
		alumnos.sort(comparador4.thenComparing(comparador3));
		
		cursos = new HashSet<String> ();
		
		alumnos.forEach(a -> cursos.add(a.getCurso()));	
		// lectura del curso
		do
		{
			System.out.println("cursos disponibles");
			cursos.forEach(ESCRIBIDOR);
			curso = Teclado.leerString("curso");		
		}while (!cursos.contains(curso));
		
		String cursoActual = curso;
		
		predicado1 = (a) -> a.getCurso().equals(cursoActual);
		predicado2 = Alumno::estaAprobado;
		
		List <Alumno> copiaAlumnos = new ArrayList<>(alumnos);
		copiaAlumnos.removeIf(predicado1.negate().or(predicado2.negate()));
		
		
		System.out.println("listado de alumnos aprobados en el curso " + curso);
		copiaAlumnos.forEach(a-> Pantalla.escribirString(a.getNombre() + " " + a.getNota() + "\n"));


		System.out.println("alumno más joven");
		Pantalla.escribirString(Collections.max(alumnos, comparador2)+"\n");
		System.out.println("alumno más viejuno");
		Pantalla.escribirString(Collections.min(alumnos, comparador2)+"\n");
	}
	
	public static List<Alumno> cargarAlumnos ()
	{
		List <Alumno> alumnos = new ArrayList<Alumno>();
		Alumno alumno;
		try (BufferedReader fichero = new BufferedReader (new FileReader ("alumnos.csv")) )
		{
			
			while (fichero.ready())
			{
				alumno = Alumno.fromCSV(fichero.readLine());
				alumnos.add(alumno);
			}
			
			/*alumnos = fichero.lines(). // obtener lineas de fichero como stream
			 * 				map(Alumno::fromCSV).// convertir la linea a un alumno
			 * 				toList();// convertir stream de alumnos a lista
			 */
			
		}
		
		catch (IOException e)
		{
			Pantalla.escribirString("\nError accediendo al fichero...");
			
		}
		
		return alumnos;
	}

}
