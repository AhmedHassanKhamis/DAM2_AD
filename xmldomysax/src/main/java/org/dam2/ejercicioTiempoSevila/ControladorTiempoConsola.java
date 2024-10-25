package org.dam2.ejercicioTiempoSevila;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import daw.com.Teclado;


public class ControladorTiempoConsola implements Controlador<Tiempo> {

	@Override
	public void leerClave(Tiempo pojo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void leerOtrosDatos(Tiempo pojo) {
		// TODO Auto-generated method stub
//		SE TENDRIA QUE HACER CONTROL DE LOS DATOS INGRESADOS
		pojo.setLocalizacion(new Localizacion(Teclado.leerString("id:"), Teclado.leerString("ciudad:"), Teclado.leerFloat("latitud:"), Teclado.leerFloat("longitud:")));
		pojo.setCondiciones(new CondicionesActuales(LocalTime.parse(Teclado.leerString("Ultima observacion:")), Teclado.leerFloat("temperatura:"), Teclado.leerFloat("sensacion termica:"), Teclado.leerString("condiciones:"), Teclado.leerString("icono:"), new Viento(Direccion.ESTE, "32"), Teclado.leerFloat("precipitacion:"), Teclado.leerFloat("presion"), Teclado.leerFloat("humedad"), Teclado.leerFloat("Visibilidad"), Teclado.leerInt("indice ultravioleta:"), Teclado.leerInt("punto rocio:")));;
		pojo.setAlerta(Teclado.leerString("alerta:"));
		List<Dato> datos = new ArrayList<Dato>();
		datos.add(new Dato(LocalDateTime.parse(Teclado.leerString("Fecha/Thora:")), Teclado.leerFloat("temperatura:"), new Viento(Direccion.ESTE, "32"), Teclado.leerFloat("precipitacion:"), Teclado.leerFloat("presion"), Teclado.leerInt("humedad")));
		pojo.setDatosRegistrados(new DatosRegistrados(LocalDateTime.parse(Teclado.leerString("introduce una fecha y hora:")), datos ));
		pojo.setPronosticoDias(null);
		pojo.setPronosticoHoras(null);
	}

}
