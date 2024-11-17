package org.dam2.grupoAlumnos.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dam2.grupoAlumnos.modelo.Alumno;

public class AlumnoDAO implements DAOInterface<Alumno, String> {

	@Override
	public Optional<Alumno> findById(String key) {
		// TODO Auto-generated method stub
		Optional<Alumno> alumno = Optional.empty();
		String sql = "SELECT * FROM ALUMNOS WHERE NIA = ?";
		try {
			PreparedStatement pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, key);
			ResultSet rs = pst.executeQuery();

			if (rs.first()) {
				alumno = Optional.of(Alumno.builder().nia(rs.getString("NIA")).nombre(rs.getString("NOMBRE"))
						.fechaNacimiento(rs.getDate("FECHANACIMIENTO").toLocalDate()).beca(rs.getBoolean("BECA"))
						.build());
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConexionBBDD.desconectar();
		}

		return alumno;
	}

	@Override
	public Iterable<Alumno> findAll() {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = new ArrayList<Alumno>();
		String sql = "SELECT * FROM ALUMNOS";
		try {
			PreparedStatement pst = ConexionBBDD.conectar().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				alumnos.add(Alumno.builder().nia(rs.getString("NIA")).nombre(rs.getString("NOMBRE"))
						.fechaNacimiento(rs.getDate("FECHANACIMIENTO").toLocalDate()).beca(rs.getBoolean("BECA"))
						.build());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConexionBBDD.desconectar();
		}

		return alumnos;
	}

	@Override
	public int delete(Alumno ov) {
		// TODO Auto-generated method stub
		int afectados = 0;
		String sql = "DELETE FROM ALUMNOS WHERE NIA = ?";
		try {
			PreparedStatement pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, ov.getNia());
			afectados = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConexionBBDD.desconectar();
		}

		return afectados;
	}

	public int save(Alumno ov) {
		// TODO Auto-generated method stub
		int afectados = 0;
		String sql = "INSERT INTO ALUMNOS (NIA,NOMBRE,FECHANACIMIENTO,BECA) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, ov.getNia());
			pst.setString(2, ov.getNombre());
			pst.setDate(3, Date.valueOf(ov.getFechaNacimiento()));
			pst.setBoolean(4, ov.isBeca());
			afectados = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConexionBBDD.desconectar();
		}
		return afectados;
	}

	public int update(Alumno ov) {
		// TODO Auto-generated method stub
		int afectados = 0;
		String sql = "UPDATE ALUMNOS SET NOMBRE = ?, FECHANACIMIENTO = ?, BECA = ?, WHERE NIA = ?";
		try {
			PreparedStatement pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(4, ov.getNia());
			pst.setString(1, ov.getNombre());
			pst.setDate(2, Date.valueOf(ov.getFechaNacimiento()));
			pst.setBoolean(3, ov.isBeca());
			afectados = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConexionBBDD.desconectar();
		}
		return afectados;
	}

	public int save(Alumno ov, String curso) {
		// TODO Auto-generated method stub
		int afectados = 0;
		String sql = "INSERT INTO ALUMNOS VALUES NIA = ?, NOMBRE = ?, FECHANACIMIENTO = ?, BECA = ?, CURSO = ?";
		try {
			PreparedStatement pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, ov.getNia());
			pst.setString(2, ov.getNombre());
			pst.setDate(3, Date.valueOf(ov.getFechaNacimiento()));
			pst.setBoolean(4, ov.isBeca());
			pst.setString(5, curso);
			afectados = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConexionBBDD.desconectar();
		}
		return afectados;
	}

	public int update(Alumno ov, String curso) {
		// TODO Auto-generated method stub
		int afectados = 0;
		String sql = "UPDATE ALUMNOS SET NOMBRE = ?, FECHANACIMIENTO = ?, BECA = ?, CURSO = ? WHERE NIA = ?";
		try {
			PreparedStatement pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(5, ov.getNia());
			pst.setString(1, ov.getNombre());
			pst.setDate(2, Date.valueOf(ov.getFechaNacimiento()));
			pst.setBoolean(3, ov.isBeca());
			pst.setString(4, curso);
			afectados = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConexionBBDD.desconectar();
		}
		return afectados;
	}

}
