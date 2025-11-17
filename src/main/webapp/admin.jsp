<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Solicitudes Registradas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/catalogo">
            📚 Biblioteca
        </a>

        <div class="d-flex">
            <a href="${pageContext.request.contextPath}/login.jsp" class="btn btn-light btn-sm me-2">
                Iniciar Sesión
            </a>
            <a href="${pageContext.request.contextPath}/admin" class="btn btn-warning btn-sm">
                Admin
            </a>
        </div>
    </div>
</nav>
<div class="container mt-4">
<h2>Solicitudes de Préstamo</h2>

<table class="table table-striped mt-3">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Correo</th>
        <th>Libro</th>
        <th>Fecha</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="s" items="${solicitudes}">
        <tr>
            <td>${s.id}</td>
            <td>${s.nombre}</td>
            <td>${s.correo}</td>
            <td>${s.libroId}</td>
            <td>${s.fechaSolicitud}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
