package org.dam2.ejercicio1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class App 
{
    public static void main( String[] args )
    {
    	List<SuperHeroes> superHeroes = leerJson();
    	System.out.println(superHeroes);
    	escribirXml(superHeroes);
    }
    
    
    public static List<SuperHeroes> leerJson(){
    	List<SuperHeroes> superHeroes = new ArrayList<SuperHeroes>();
    	
    	try {
    		GsonBuilder creadorGson = new GsonBuilder();
    		creadorGson.registerTypeAdapter (Powers.class, new PowersAdapterJson());
    		creadorGson.registerTypeAdapter (boolean.class, new BooleanAdapterJson());
    		Gson gson = creadorGson.create();
    		 Type listaDeObjetos = TypeToken.getParameterized(List.class, SuperHeroes.class).getType();
    		superHeroes = gson.fromJson(new FileReader("examen.json"), listaDeObjetos);
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
    	return superHeroes;
    }
    
    
    public static void escribirXml(List<SuperHeroes> superHeroes) {
    	List<Member> miembros = superHeroes.stream().flatMap(s -> s.getMembers().stream()).collect(Collectors.toList());
    	WrapperMember wrapper = new WrapperMember(miembros);
    	try {
    		Writer writer = new FileWriter("examen.xml");
    		JAXBContext context = JAXBContext.newInstance(WrapperMember.class);
    		Marshaller ms = context.createMarshaller();
    		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    		ms.marshal(wrapper, writer);
    		writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
    	System.out.println("fichero escrito con exito");
    }
    
    
}
