package com.skillnest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.skillnest.dao.LibroDAO;
import com.skillnest.dao.SolicitudDAO;
import com.skillnest.model.Libro;
import com.skillnest.model.Solicitud;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		SolicitudDAO solicitudDAO = new SolicitudDAO();
		LibroDAO libroDAO = new LibroDAO();
		try {
			List<Solicitud> solicitudes = solicitudDAO.obtenerTodas();
			List<Libro> libros = libroDAO.obtenerTodos();

			Map<Integer, Libro> mapaLibros = new HashMap<>();
			for (Libro l : libros)
				mapaLibros.put(l.getId(), l);

			request.setAttribute("solicitudes", solicitudes);
			request.setAttribute("mapaLibros", mapaLibros);
			request.getRequestDispatcher("/admin.jsp").forward(request, response);
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
