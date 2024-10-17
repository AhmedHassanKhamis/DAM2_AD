package org.dam2.xmldomysax;
import java.io.File;
import java.time.LocalDate;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerEmpleado {
	
	public static void main (String args[])
	{
		DocumentBuilderFactory factory;
		
		factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("EmpleadosBis.xml"));
			
			document.getDocumentElement().normalize();
			
			// Elemento raiz
			
			System.out.println("Raiz: " + document.getDocumentElement().getNodeName());
			
			// Crear una lista con todos los nodos empleado
			NodeList empleados = document.getElementsByTagName("empleado");
			
			//NodeList hijos = document.getDocumentElement().getChildNodes();
			// Recorrer la ista
			/*
			for (int i = 0; i < empleados.getLength(); i++)
			{
				// Obtener un empleado de la lista
				Node emple = empleados.item(i);
				//System.out.println("Tipo nodo " + emple.getNodeType());
				if (emple.getNodeType() == Node.ELEMENT_NODE)
				{	
					Empleado empleado = crearEmpleado(emple);
					System.out.println(empleado.toString());
				}
				
			}
			*/
			Stream.iterate(0, i -> i +1). // crear iterador de enteros (0,1,2,3,..)
					limit(empleados.getLength()).// limitar iterador al tamaño de la lista
					map(empleados::item).// obtener elemento i de la lista
					filter(emp -> emp.getNodeType() == Node.ELEMENT_NODE).
					map(LeerEmpleado::crearEmpleado).
					forEach(System.out::println);
			
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getNodo (String etiqueta, Element elemento)
	{
		
		Node valorNodo = elemento.getElementsByTagName(etiqueta).item(0);
		
		return valorNodo.getTextContent();
	}
	
	public static String getAtributo (String atributo,Element elemento)
	{
		
		return elemento.getAttribute(atributo);
	}
	
	public static Empleado crearEmpleado (Node emple)
	{
		Element elemento = (Element) emple;
		
		return Empleado.builder().
				id(getAtributo ("id", elemento)).
				nombre(getNodo ("nombre", elemento)).
				dept(getNodo ("dept", elemento)).
				sueldo(Float.parseFloat(getNodo ("sueldo", elemento))).
				fechaNacimiento(LocalDate.parse(getNodo ("fechaNacimiento", elemento))).
				build();

	}

}
