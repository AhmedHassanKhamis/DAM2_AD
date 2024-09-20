package ejercicioLambdas;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor //constructor con parametros
@NoArgsConstructor //constructor sin parametros
@Data
@EqualsAndHashCode
@Builder
@ToString
public class Alumno {
	
	private String dni;
	private String nombre;
	private LocalDate fecha;
	private float nota;
	private boolean repetidor; 
	private String curso;
	
	
}
