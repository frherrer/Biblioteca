package com.skillnest.dao;

import com.skillnest.model.Solicitud;
import com.skillnest.util.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolicitudDAO {
	private Connection conn;

	public SolicitudDAO() {
		conn = ConexionDB.getInstancia().getConexion();
	}

	public int insertar(Solicitud s) throws SQLException {
		String sql = "INSERT INTO solicitudes (nombre, correo, libro_id) VALUES (?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, s.getNombre());
			ps.setString(2, s.getCorreo());
			ps.setInt(3, s.getLibroId());
			int affected = ps.executeUpdate();
			if (affected == 0)
				return -1;
			try (ResultSet keys = ps.getGeneratedKeys()) {
				if (keys.next()) {
					return keys.getInt(1);
				}
			}
			return -1;
		}
	}

	public List<Solicitud> obtenerTodas() throws SQLException {
		List<Solicitud> lista = new ArrayList<>();
		String sql = "SELECT id, nombre, correo, libro_id, fecha_solicitud FROM solicitudes ORDER BY fecha_solicitud DESC";
		try (PreparedStatement ps = conn.prepareStatement(sql); 
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Solicitud s = new Solicitud(rs.getInt("id"), rs.getString("nombre"), rs.getString("correo"),
						rs.getInt("libro_id"), rs.getTimestamp("fecha_solicitud"));
				lista.add(s);
			}
		}
		return lista;
	}
}
