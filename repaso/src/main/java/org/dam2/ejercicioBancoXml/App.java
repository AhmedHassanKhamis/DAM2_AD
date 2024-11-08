package org.dam2.ejercicioBancoXml;

import java.io.File;
import java.io.FileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco banco = leerXML();
		System.out.println(banco);
		escribirXML(banco);
	}
	
	public static Banco leerXML() {
		Banco banco = new Banco();
		try {
			JAXBContext context = JAXBContext.newInstance(Banco.class);
			Unmarshaller ums = context.createUnmarshaller();
			banco = (Banco) ums.unmarshal(new File("banco.xml"));	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return banco;
	}
	
	public static void escribirXML(Banco banco) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(Banco.class);
			Marshaller ms = context.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(banco, new FileWriter("bancoMoro.xml"));
			ms.marshal(banco, System.out);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

}
