package com.skillnest.dao;

import com.skillnest.model.Usuario;
import com.skillnest.util.ConexionDB;
import java.sql.*;

public class UsuarioDAO {
	private Connection conn;

	public UsuarioDAO() {
		conn = ConexionDB.getInstancia().getConexion();
	}
	
	 public Usuario login(String username, String password) throws SQLException {
	        String sql = "SELECT id, username, password, nombre FROM usuarios WHERE username = ? AND password = ?";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, username);
	            ps.setString(2, password); // in production, use hashed passwords
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    return new Usuario(
	                        rs.getInt("id"),
	                        rs.getString("username"),
	                        rs.getString("password"),
	                        rs.getString("nombre")
	                    );
	                }
	            }
	        }
	        return null;
	    }
}
