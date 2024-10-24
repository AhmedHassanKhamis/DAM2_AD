package org.dam2.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
        String json;
        Empleado empleado = Empleado.builder()
        		.id("001")
        		.dept("d1")
        		.nombre("e1")
        		.sueldo(200)
        		.build();
        
        GsonBuilder creadorGson = new GsonBuilder().setPrettyPrinting();
        gson = creadorGson.create();
        File f = new File("empleados.json");
        PrintWriter fichero = new PrintWriter(f);
	    gson.toJson(empleado,fichero);

        System.out.println(gson.toJson(empleado));
        
        
    }
}
