<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String idLibro = request.getParameter("id");
%>
<html>
<head>
    <title>Solicitar Préstamo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">

<h2>Solicitud de Préstamo</h2>

<form action="solicitud" method="post" class="mt-4">

    <div class="mb-3">
        <label class="form-label">Nombre:</label>
        <input type="text" name="nombre" class="form-control" required />
    </div>

    <div class="mb-3">
        <label class="form-label">Correo:</label>
        <input type="email" name="correo" class="form-control" required />
    </div>

    <div class="mb-3">
        <label class="form-label">ID del Libro:</label>
        <input type="number" name="libroId" class="form-control" 
       value="<%= idLibro %>" readonly />
    </div>

    <button type="submit" class="btn btn-primary">Enviar solicitud</button>
</form>

</body>
</html>
