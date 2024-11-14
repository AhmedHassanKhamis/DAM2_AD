package org.dam2.grupoAlumnos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class GrupoDAO implements DAOInterface<Grupo, String>{

	@Override
	public Optional<Grupo> findById(String key) {
		Optional<Grupo> grupo = Optional.empty();
		String sql = "SELECT * FROM GRUPOS WHERE NOMBRE = ?";
		try {
			PreparedStatement pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, key);

			ResultSet rs = pst.executeQuery();
			
			if (rs.first()) {
				rs.getstr
			} 
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
		}
		
		
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
