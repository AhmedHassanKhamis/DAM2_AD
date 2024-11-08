package org.dam2.ejercicioExtraXMLtoJson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Widget widget = leerXml();
//		System.out.println(widget);
		escribirJson(widget);

	}
	
	public static Widget leerXml() {
		Widget widget = new Widget();
		
		try {
			
			JAXBContext context = JAXBContext.newInstance(Widget.class);
			Unmarshaller ums = context.createUnmarshaller();
			widget = (Widget) ums.unmarshal(new FileReader("widget.xml"));
			
			Marshaller ms = context.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(widget, System.out);

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return widget;
	}
	
	
	public static void escribirJson(Widget widget) {
		try {
			Writer writer = new FileWriter("widget.json");
			GsonBuilder creadorGson = new GsonBuilder();
			creadorGson.setPrettyPrinting();
			Gson gson = creadorGson.create();
			gson.toJson (widget, writer);	
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		System.out.println("fichero escrito");

		
	}

}
