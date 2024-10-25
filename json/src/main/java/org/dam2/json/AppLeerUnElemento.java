package org.dam2.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AppLeerUnElemento {
	public static void main(String[] args) throws IOException {
	
		System.out.println(leerEmpleado());
		
		
		
	}
	
	public static Empleado leerEmpleado() throws IOException {
		Empleado e;
		Gson gson = new Gson();
		Reader reader = new FileReader (new File("empleado.json"));
		
		
		
		e = gson.fromJson(reader, Empleado.class);
		
		reader.close();
		return e;
	}
	
	public static List leerLista() throws IOException {
		List<Empleado> empleados;
		Gson gson = new Gson();
		Reader reader = new FileReader (new File("empleados.json"));
//		para crear una clase rapida de typetoken
		TypeToken<List<Empleado>> listaEmpleados = new TypeToken<List<Empleado>>() {};
		
		empleados = gson.fromJson(reader, listaEmpleados);
		
		reader.close();
		return empleados;
	}

}
