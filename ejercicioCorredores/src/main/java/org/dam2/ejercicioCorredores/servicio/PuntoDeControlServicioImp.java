package org.dam2.ejercicioCorredores.servicio;

import org.dam2.ejercicioCorredores.modelo.PuntoDeControl;
import org.dam2.ejercicioCorredores.repositorio.PuntoDeControlRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuntoDeControlServicioImp implements IPuntoDeControlServicio {

	@Autowired PuntoDeControlRepositorio puntoDeControlDAO;
	
	@Override
	public boolean insert(PuntoDeControl puntoDeControl) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (!puntoDeControlDAO.existsById(puntoDeControl.getKm())) {
			puntoDeControlDAO.save(puntoDeControl);
			exito = true;
		}
		
		return exito;
	}

}
