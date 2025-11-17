package com.skillnest.dao;

import com.skillnest.model.Libro;
import com.skillnest.util.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {
	private Connection conn;

	public LibroDAO() {
		conn = ConexionDB.getInstancia().getConexion();
	}

	public List<Libro> obtenerTodos() throws SQLException {
		List<Libro> lista = new ArrayList<>();
		String sql = "SELECT id, titulo, autor, disponible,imagen FROM libros ORDER BY titulo";
		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Libro l = new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"),
						rs.getBoolean("disponible"), rs.getString("imagen"));
				lista.add(l);
			}
		}
		return lista;
	}

	public Libro obtenerPorId(int id) throws SQLException {
		String sql = "SELECT id, titulo, autor, disponible,imagen FROM libros WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"),
							rs.getBoolean("disponible"), rs.getString("imagen"));
				}
			}
		}
		return null;
	}

	public boolean actualizarDisponibilidad(int id, boolean disponible) throws SQLException {
		String sql = "UPDATE libros SET disponible = ? WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setBoolean(1, disponible);
			ps.setInt(2, id);
			return ps.executeUpdate() > 0;
		}
	}
}
