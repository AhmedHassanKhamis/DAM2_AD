package org.dam2.grupoAlumnos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
				grupo = Optional.of( Grupo.builder()
						.nombre(rs.getString("nombre"))
						.tutor(rs.getNString("tutor"))
						.curso(rs.getInt("curso"))
						.alumnos(new ArrayList<Alumno>())
						.build());
			} 
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally { 
			// TODO: handle finally clause
			ConexionBBDD.desconectar();
		}
		
		
		// TODO Auto-generated method stub
		return grupo;
	}

	@Override
	public Iterable<Grupo> findAll() {
		// TODO Auto-generated method stub
		List<Grupo> grupos = new ArrayList<Grupo>();
		String sql = "select * from grupos";
		
		try {
			PreparedStatement pst = ConexionBBDD.conectar().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				grupos.add(Grupo.builder()
						.nombre(rs.getString("NOMBRE"))
						.tutor(rs.getString("TUTOR"))
						.curso(rs.getInt("CURSO"))
						.alumnos(new ArrayList<Alumno>())
						.build());
			}
			
			return grupos;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConexionBBDD.desconectar();
			
		}

		
		
		return null;
	}

	@Override
	public int delete(Grupo ov) {
		// TODO Auto-generated method stub
		int afectados = 0;
		String sql = "DELETE FROM GRUPOS WHERE NOMBRE = ?";
		try {
			PreparedStatement pst = ConexionBBDD.conectar().prepareStatement(sql);
			afectados = pst.executeUpdate();
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConexionBBDD.desconectar();
		}
		
		return afectados;
	}

	@Override
	public int save(Grupo ov) {
		// TODO Auto-generated method stub
		int afectados = 0;
		String sql = "INSERT INTO GRUPOS VALUES(?,?,?,?)";
		try {
			PreparedStatement pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, ov.getNombre());
			pst.setString(2, ov.getTutor());
			pst.setInt(3, ov.getCurso());
			afectados = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConexionBBDD.desconectar();
		}
		
		return afectados;
		
	}

	@Override
	public int update(Grupo ov) {
		// TODO Auto-generated method stub
		int afectados =0;
		String sql = "UPDATE GRUPOS SET NOMBRE= ?, TUTOR= ?, CURSO=?";
		try {
			PreparedStatement pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, ov.getNombre());
			pst.setString(2, ov.getTutor());
			pst.setInt(3, ov.getCurso());
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConexionBBDD.desconectar();
		}
		
		
		return afectados;
	}

}
