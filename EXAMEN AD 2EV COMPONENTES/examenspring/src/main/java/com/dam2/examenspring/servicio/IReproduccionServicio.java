package com.dam2.examenspring.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.dam2.examenspring.modelo.Cancion;
import com.dam2.examenspring.modelo.Reproduccion;
import com.dam2.examenspring.modelo.Usuario;

public interface IReproduccionServicio {
	@Transactional
	public boolean insert(Reproduccion reproduccion);

	public List<Cancion> cancionesNoEscuchadas(Usuario usuario);
	
	public Optional<Reproduccion> buscarPorUsuarioCancionFecha(Reproduccion reproduccion);

	public List<String> estadisticasCancion(String cancion);
}
