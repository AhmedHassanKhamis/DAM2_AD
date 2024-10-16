package org.dam2.empleydepart;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.opencsv.bean.CsvDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Emple {
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 0)
	private String dni;
	@CsvBindByPosition(position = 1)
	private String nombre;
	@CsvCustomBindByPosition(position=2,converter = BooleanToText.class)
	private boolean mujer;
	@CsvBindByPosition(position = 3)
	@CsvDate("yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@CsvBindByPosition(position = 4)
	@CsvDate("yyyy-MM-dd")
	private LocalDate fechaIncorporacion;
	@CsvBindByPosition(position = 5)
	private float salario;
	@CsvBindByPosition(position = 6)
	private float comision;
	@CsvBindByPosition(position = 7)
	private String cargo;
	@CsvCustomBindByPosition(position=8,converter = OptionalToText.class)
	private Optional<Emple> jefe;
	/*
	public Emple()
	{
		System.out.println("constructor por defecto");
		jefe = Optional.empty();
	}
	*/
	/*
	public Emple(String dni, String nombre, boolean mujer, LocalDate fechaNacimiento, LocalDate fechaIncorporacion,
			float salario, float comision, String cargo, Emple jefe) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.mujer = mujer;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIncorporacion = fechaIncorporacion;
		this.salario = salario;
		this.comision = comision;
		this.cargo = cargo;
		this.jefe = Optional.ofNullable(jefe);
	}

	public void setJefe(Emple jefe) {
		this.jefe = Optional.ofNullable(jefe);
	}
	*/
	/*
	public void setJefe (Optional<Emple> jefe)
	{
		System.out.println("set jefe "+ jefe);
		this.jefe = jefe== null?Optional.empty():jefe;
	}

	*/
	@Override
	public String toString() {
		return "Emple [dni=" + dni + ", nombre=" + nombre + ", sexo=" + (mujer?"Mujer":"Hombre") + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaIncorporacion=" + fechaIncorporacion + ", salario=" + salario + ", comision=" + comision
				+ ", cargo=" + cargo + ", jefe=" + jefe.map(Emple::getDni).orElse("sin jefe") + "]";
	}
	
/*	
	public static Emple fromCSV (String linea)
	{
		Emple empleado;
		String valores[] = linea.split(",");
		Optional<Emple> jefe;
		
		empleado = Emple.builder().
						dni(valores[0]).
						nombre(valores[1]).
						mujer(valores[2].equals("Mujer")).
						fechaNacimiento(LocalDate.parse(valores[3])).
						fechaIncorporacion(LocalDate.parse(valores[4])).
						salario(Float.valueOf(valores[5])).
						comision(Float.valueOf(valores[6])).
						cargo(valores[7]).
						build();
		
		
		jefe = valores[8].equals("sin jefe")? 
				Optional.empty():
				Optional.of(Emple.builder().dni(valores[8]).build());
		empleado.setJefe(jefe);
		
		return empleado;
	}
	*/
}
