package org.dam2.grupoyalumnos.dao;

import java.util.Optional;

import org.dam2.grupoyalumnos.modelo.Alumno;

public class AlumnoDAO implements DAOInterface<Alumno, String> {

	@Override
	public Optional<Alumno> findById(String key) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Iterable<Alumno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Alumno ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Alumno ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Alumno ov) {
		// TODO Auto-generated method stub
		return 0;
	}

}
