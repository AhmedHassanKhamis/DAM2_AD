package org.dam2.pruebaspring.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.dam2.pruebaspring.modelo.Alumno;
import org.dam2.pruebaspring.repositorio.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "labuena")
public class ServicioAlumnoImpl implements IServicioAlumno {

	@Autowired
	AlumnoRepositorio alumnoDAO;

	@Override
	public boolean insertar(Alumno a) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (!alumnoDAO.existsById(a.getNia())) {
			alumnoDAO.save(a);
			exito = true;
		}

		return exito;
	}

	@Override
	public boolean actualizar(Alumno a) {
		// TODO Auto-generated method stub
		boolean exito = false;

		if (alumnoDAO.existsById(a.getNia())) {
			alumnoDAO.save(a);
			exito = true;
		}

		return exito;
	}

	@Override
	public boolean borrar(String nia) {
		// TODO Auto-generated method stub
		boolean exito = false;

		if (alumnoDAO.existsById(nia)) {
			alumnoDAO.deleteById(nia);
			exito = true;
		}

		return exito;
	}

	@Override
	public Optional<Alumno> buscarPorClave(String nia) {
		// TODO Auto-generated method stub
		return alumnoDAO.findById(nia);
	}

	@Override
	public Stream<Alumno> buscarTodos() {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = (List<Alumno>) alumnoDAO.findAll();
		return alumnos.stream();
	}

	@Override
	public int sumarUnPunto(int nota) {
		// TODO Auto-generated method stub
		return alumnoDAO.subirPunto(nota);
	}

	@Override
	public Optional<Float> calcularMedia() {
		// TODO Auto-generated method stub
		return alumnoDAO.calcularMedia();
	}

}
