package org.dam2.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.GsonBuildConfig;

import lombok.Builder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
    	
    	Gson gson;
        List<Empleado> empleados = new ArrayList<Empleado>();
        Empleado empleado = Empleado.builder()
        		.id("001")
        		.dept("d1")
        		.nombre("e1")
        		.sueldo(200)
        		.fechaNacimiento(LocalDate.now())
        		.build();
        
        Empleado empleado2 = Empleado.builder()
        		.id("002")
        		.dept("d2")
        		.nombre("e2")
        		.sueldo(200)
        		.fechaNacimiento(LocalDate.now())
        		.build();
        
        empleados.add(empleado);
        empleados.add(empleado2);
        
        GsonBuilder creadorGson = new GsonBuilder().setPrettyPrinting();
        gson = creadorGson.create();
        File f = new File("empleadosAmazing.json");
        PrintWriter fichero = new PrintWriter(f);
	    gson.toJson(empleados,fichero);

        System.out.println(gson.toJson(empleados));
        fichero.close();
        
        
    }
}
