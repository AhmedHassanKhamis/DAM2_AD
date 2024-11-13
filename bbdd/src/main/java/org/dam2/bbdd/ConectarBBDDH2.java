package org.dam2.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectarBBDDH2 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		String usuario = "sa";
		String password = "";
		String urlConexion = "jdbc:h2:";
		String bd = "~/test";
		
		String url = urlConexion + bd;
		
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password))
		{
	
			//Class.forName("org.h2.Driver");

			System.out.println("conexion realizada correctamente");

			// Mostrar datos

			//String sql = "SELECT * FROM DEPART";
			//Statement st = conn.createStatement();
			//ResultSet rs = st.executeQuery(sql);
			
			
			// Consultar datos por clave
			String sql = "SELECT * FROM departamento WHERE id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "001");
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.first()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("nombre"));
				System.out.println(rs.getString("localidad"));
				System.out.println(rs.getDate("fecha_creacion"));
			}
			else
				System.out.println("el departamento no existe");
		}
		catch (SQLException  e) {
			e.printStackTrace();
		}
		
		

	}

}
