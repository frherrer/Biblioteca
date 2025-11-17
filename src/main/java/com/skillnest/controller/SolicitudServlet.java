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
/**
 * Servlet implementation class SolicitudServlet
 */
@WebServlet("/solicitud")
public class SolicitudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitudServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
	            LibroDAO libroDAO = new LibroDAO();
	            request.setAttribute("libros", libroDAO.obtenerTodos());
	            request.getRequestDispatcher("/solicitud.jsp").forward(request, response);
	        } catch (SQLException e) {
	            throw new ServletException(e);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String nombre = request.getParameter("nombre");
	        String correo = request.getParameter("correo");
	        String libroIdStr = request.getParameter("libroId");

	        if (nombre == null || nombre.trim().isEmpty()
	                || correo == null || correo.trim().isEmpty()
	                || libroIdStr == null || libroIdStr.trim().isEmpty()) {
	            request.setAttribute("error", "Todos los campos son obligatorios.");
	            try {
	                LibroDAO libroDAO = new LibroDAO();
	                request.setAttribute("libros", libroDAO.obtenerTodos());
	            } catch (SQLException ex) {
	                throw new ServletException(ex);
	            }
	            request.getRequestDispatcher("/solicitud.jsp").forward(request, response);
	            return;
	        }

	        int libroId;
	        try {
	            libroId = Integer.parseInt(libroIdStr);
	        } catch (NumberFormatException ex) {
	            request.setAttribute("error", "ID de libro inválido.");
	            try {
	                LibroDAO libroDAO = new LibroDAO();
	                request.setAttribute("libros", libroDAO.obtenerTodos());
	            } catch (SQLException e) {
	                throw new ServletException(e);
	            }
	            request.getRequestDispatcher("/solicitud.jsp").forward(request, response);
	            return;
	        }

	        try {
	            LibroDAO libroDAO = new LibroDAO();
	            Libro libro = libroDAO.obtenerPorId(libroId);
	            if (libro == null) {
	                request.setAttribute("error", "Libro no encontrado.");
	                request.setAttribute("libros", libroDAO.obtenerTodos());
	                request.getRequestDispatcher("/solicitud.jsp").forward(request, response);
	                return;
	            }
	            if (!libro.isDisponible()) {
	                request.setAttribute("error", "El libro seleccionado no está disponible.");
	                request.setAttribute("libros", libroDAO.obtenerTodos());
	                request.getRequestDispatcher("/solicitud.jsp").forward(request, response);
	                return;
	            }

	            Solicitud solicitud = new Solicitud();
	            solicitud.setNombre(nombre.trim());
	            solicitud.setCorreo(correo.trim());
	            solicitud.setLibroId(libroId);

	            SolicitudDAO solicitudDAO = new SolicitudDAO();
	            int idGenerado = solicitudDAO.insertar(solicitud);
	            if (idGenerado > 0) {
	                // marcar libro como no disponible
	                libroDAO.actualizarDisponibilidad(libroId, false);

	               
	                request.setAttribute("solicitudId", idGenerado);
	                request.setAttribute("nombre", nombre.trim());
	                request.setAttribute("correo", correo.trim());
	                request.setAttribute("libro", libro);
	                request.getRequestDispatcher("/confirmacion.jsp").forward(request, response);
	            } else {
	                request.setAttribute("error", "No se pudo guardar la solicitud.");
	                request.setAttribute("libros", libroDAO.obtenerTodos());
	                request.getRequestDispatcher("/solicitud.jsp").forward(request, response);
	            }
	        } catch (SQLException e) {
	            throw new ServletException(e);
	        }
	}

}
