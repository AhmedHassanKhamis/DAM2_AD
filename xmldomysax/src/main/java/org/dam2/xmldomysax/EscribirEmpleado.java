package org.dam2.xmldomysax;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import daw.com.Teclado;

public class EscribirEmpleado {

	public static void main(String[] args) throws ParserConfigurationException, 
							TransformerFactoryConfigurationError, 
							TransformerException 
	{

		
		DocumentBuilderFactory factory;
		
		factory = DocumentBuilderFactory.newInstance();
		

		DocumentBuilder builder = factory.newDocumentBuilder();
		
		// Crear documento vacio con raiz empleados
		DOMImplementation implementation  = builder.getDOMImplementation();
		Document document = implementation.createDocument(null, "empleados", null);
		document.setXmlVersion("1.0");
		
		
		String respuesta ;
		do
		{
			// Leer empleado
			Empleado empleado = new Empleado ();
			Controlador<Empleado> controlador = new ControladorEmpleadoConsola();
			controlador.leerDatos(empleado);
			
			// A�adir nodo empleado
			Element nodoEmpleado = document.createElement("empleado");
			document.getDocumentElement().appendChild(nodoEmpleado);
			
			// Insertar datos empelados
			crearAtributo ("id", empleado.getId(), nodoEmpleado, document);
			crearElemento ("nombre", empleado.getNombre(), nodoEmpleado, document);
			crearElemento ("dept", empleado.getDept(), nodoEmpleado, document);
			crearElemento ("sueldo", Float.toString(empleado.getSueldo()), nodoEmpleado, document);
			crearElemento ("fechaNacimiento", empleado.getFechaNacimiento().toString(), nodoEmpleado, document);
			respuesta = Teclado.leerString("Introducir otro (S/N)");
			
		}while (respuesta.equals("S"));
		
		
		// Escribir DOM en fichero XML
		Source source = new DOMSource(document);
		//Result result = new StreamResult (new File ("EmpleadosBis.xml"));
		Result result = new StreamResult (System.out);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Mostrar formateado
		transformer.transform(source, result);
		

	}
	
	public static void crearElemento (String etiqueta, String valor, Element padre, Document document)
	{
		Element elem = document.createElement(etiqueta); // Crear hijo
		Text text = document.createTextNode(valor); // Dar valor
		
		padre.appendChild(elem); // Pegar elemento hijo al padre
		elem.appendChild(text); // Pegar valor al elemento hijo
		
	}
	
	public static void crearAtributo (String nombreAtributo, String valor, Element elemento, Document document)
	{
		Attr atributo = document.createAttribute(nombreAtributo);
		atributo.setNodeValue(valor);
		elemento.setAttributeNode(atributo);
	}
}
