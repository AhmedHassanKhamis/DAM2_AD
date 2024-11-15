package org.dam2.grupoyalumnos.dao;

import java.util.Optional;

import org.dam2.grupoyalumnos.modelo.Grupo;

public class GrupoDAO implements DAOInterface<Grupo, String> {

	@Override
	public Optional<Grupo> findById(String key) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Iterable<Grupo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Grupo ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Grupo ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Grupo ov) {
		// TODO Auto-generated method stub
		return 0;
	}

}
