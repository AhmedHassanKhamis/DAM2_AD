package ejercicioLambdas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.text.DateFormatter;

public class App {

	public static void main(String[] args) throws IOException {
		
		Comparator<Alumno> comparador;
		List<Alumno> alumnos = new ArrayList<>();
		
		
		File ficheroAlumnos = new File("../MOCK_DATA.csv");
		 try(BufferedReader reader = new BufferedReader(new FileReader(ficheroAlumnos))) {
	            String linea;
	            String delimiter = ";";
	            while((linea = reader.readLine()) != null) {
		            Alumno alumnoTmp = new Alumno();
	            	String[] campos = linea.split(delimiter);
	            	alumnoTmp.setDni(campos[0]);
	            	alumnoTmp.setNombre(campos[1]);
	            	alumnoTmp.setFecha(LocalDate.parse(campos[2]));
	            	alumnoTmp.setNota(Float.parseFloat(campos[3]));
	            	alumnoTmp.setRepetidor(Boolean.parseBoolean(campos[4]));
	            	alumnoTmp.setCurso(campos[5]);	
	            	
	            	alumnos.add(alumnoTmp);
	            }
	        } catch (IOException e) {
	        	throw new IOException(e);
	        }
		 
		 
		 System.out.println(alumnos);
		
	}

}
