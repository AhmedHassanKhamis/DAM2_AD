package ejercicioLambdas;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import daw.com.Pantalla;
import daw.com.Teclado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder


public class Alumno {
	@ToString.Exclude
	private static final LocalDate FECHATOPE = LocalDate.now().minusYears(17);
	
	// atributos
	@EqualsAndHashCode.Include
	@NonNull
	private String nia;
	private String nombre;
	private LocalDate fecha;
	private float nota;
	private boolean repetidor;
	private String curso;
	
	
	public void setFecha(LocalDate fecha) throws IllegalArgumentException 
	{
		if (fecha == null || fecha.isAfter(FECHATOPE))
			throw new IllegalArgumentException ("fecha incorrecta");
		
		this.fecha = fecha;
	}

	
	public void setNota(float nota) {
		if (nota < 1)
			nota = 1;
		else if (nota > 10)
			nota = 10;
			
		this.nota = nota;
	}

	
	public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos ();
	}
	
	public void leerClave ()
	{
		nia = Teclado.leerString("nia");
	}
	
	public void leerOtrosDatos ()
	{
		
		boolean fechaCorrecta;
		nombre = Teclado.leerString("nombre");
		
		
		do
		{
			fechaCorrecta = true;
			try
			{
				fecha = LocalDate.parse(Teclado.leerString("fecha"));
				setFecha (fecha);
			}
			catch (DateTimeParseException | IllegalArgumentException ex)
			{
				Pantalla.escribirString("\nError en la fecha");
				fechaCorrecta = false;
			}
		}while (!fechaCorrecta);
		
		
		setNota (Teclado.leerFloat("nota"));
		
		repetidor = Teclado.leerString("Repetidor(S/N)").equalsIgnoreCase("S");
		
		curso = Teclado.leerString("curso");
		
	}
	
	public boolean estaAprobado ()
	{
		return nota >= 5;
	}
	
	public String toCSV ()
	{
		return nia + ";" + nombre + ";" + fecha + ";" + nota + ";"
				+ repetidor + ";" + curso + "\n";
		
	}
	
	public static Alumno fromCSV (String lineaCSV)
	{
		Alumno alumno = new Alumno ();
		String[] campos = lineaCSV.split(";");
		alumno.nia = campos[0];
		alumno.nombre = campos[1];
		
		alumno.setFecha (LocalDate.parse(campos[2]));
			
		alumno.setNota(Float.parseFloat(campos[3]));
		
		alumno.repetidor = Boolean.parseBoolean(campos[4]);
		
		alumno.setCurso(campos[5]);
		
		return alumno;
	}
	
}