package com.dam2.examenspring.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import com.dam2.examenspring.modelo.Cancion;

public interface ICancionServicio {
	
	public boolean insert(Cancion cancion);

}
