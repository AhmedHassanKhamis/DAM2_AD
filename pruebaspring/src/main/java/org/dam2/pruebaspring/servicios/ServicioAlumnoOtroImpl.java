package org.dam2.pruebaspring.servicios;

import java.util.Optional;
import java.util.stream.Stream;

import org.dam2.pruebaspring.modelo.Alumno;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
@Qualifier(value = "otro")
public class ServicioAlumnoOtroImpl implements IServicioAlumno {

	@Override
	public boolean insertar(Alumno a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(Alumno a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(String nia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Alumno> buscarPorClave(String nia) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Stream<Alumno> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sumarUnPunto(int nota) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Float> calcularMedia() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
