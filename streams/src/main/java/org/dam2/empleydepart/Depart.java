package org.dam2.empleydepart;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Depart {
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 0)
	private String codigo;
	@CsvBindByPosition(position = 1)
	private String nombre;
	@CsvBindByPosition(position = 2)
	private String ciudad;
	@CsvBindAndSplitByPosition(position = 3, 
								elementType= Emple.class, // tipo de elemento de la colección
								splitOn = ";", // separador de empleados
								converter = CSVToEmple.class // Clase convertidora
								,writeDelimiter = ";")
	private Set<Emple> empleados;

	public Depart(String codigo, String nombre, String ciudad) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.empleados = new HashSet<Emple> ();
	}

	
	public boolean addEmple (Emple empleado)
	{
		if (empleados == null)
			empleados = new HashSet<Emple> ();
		return empleados.add(empleado);
	}
	
	/*
	public static Depart fromCSV (String linea)
	{
		Depart nuevo = new Depart();
		String valores[] = linea.split(",");
		int cuantosEmpleados,porDonde;
		Emple empleado;
		String empleadoCSV;
		
		nuevo.setCodigo(valores[0]);
		nuevo.setNombre(valores[1]);
		nuevo.setCiudad(valores[2]);
		cuantosEmpleados = Integer.valueOf(valores[3]);
		porDonde  = 4;
		// Leer los empleados
		for (int i = 0; i < cuantosEmpleados; i++)
		{
			empleadoCSV = "";
			for (int j = 0; j < 9; j++)
			{
				empleadoCSV = empleadoCSV + valores[porDonde]+",";
				porDonde++;
			}
			empleadoCSV = empleadoCSV.substring(0, empleadoCSV.length()-1);
			
			empleado = Emple.fromCSV (empleadoCSV);
			nuevo.addEmple(empleado);
			
		}
		
		// ajustar jefes empleados
		nuevo.getEmpleados().stream().forEach (e -> nuevo.ajustarJefe(e));
		return nuevo;
	}

	private void ajustarJefe (Emple empleado)
	{
		Optional<Emple> jefe;
		
		jefe = empleados.stream().
				filter(e -> e.getDni().equals(empleado.getDni())).
				findFirst();
	}
	*/
}
