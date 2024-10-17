package org.dam2.xmldomysax;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter(value = AccessLevel.PRIVATE)

public class GestorEventos extends DefaultHandler {
	private Set<Empleado> empleados;
	@Getter(value = AccessLevel.PRIVATE)
	private Empleado porDondeVoy;
	@Getter(value = AccessLevel.PRIVATE)
	private String elementoActual;
	
	
	public void startDocument()
	{
		empleados = new HashSet<> (); 
		//System.out.println("Inicio documento");
	}
	
	public void endDocument()
	{
		//System.out.println("Fin documento");
	}

	
	public void startElement (String uri, String localName, String qName, Attributes atts)  
	{
		
		//System.out.println("\tInicio elemento " + uri + " " + localName + " " + qName);
		/*
		for (int i = 0; i < atts.getLength(); i++)
			System.out.println("\t\t" + atts.getLocalName(i) + ", " + atts.getValue(i));
		*/
		
		elementoActual = qName;
		

		if (elementoActual.equals("empleado"))
				porDondeVoy = Empleado.builder().
									id(atts.getValue("id")).
									build();

		
	}
	
	public void endElement(String uri, String localName, String qName)
	{
		//System.out.println("\tFin elemento " + localName + qName );
		if (qName.equals("empleado"))
			empleados.add(porDondeVoy);
		
		elementoActual = "";
	}
	
	public void characters(char[] ch, int start, int length) 
	{
		String contenido = new String (ch, start, length);
		
		contenido = contenido.replaceAll("[\t\n]", "");
		
		switch (elementoActual)
		{
			case "nombre":
				porDondeVoy.setNombre(contenido);
				break;
			case "dept":
				porDondeVoy.setDept(contenido);
				break;
			case "sueldo":
				porDondeVoy.setSueldo(Float.valueOf(contenido));
				break;
			case "fechaNacimiento":
				porDondeVoy.setFechaNacimiento(LocalDate.parse(contenido));
		}
		
	}

}
