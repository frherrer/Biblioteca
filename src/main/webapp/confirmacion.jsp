<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Confirmación</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">

<h2>Solicitud registrada correctamente</h2>

<p class="mt-3">
    Gracias <strong>${nombre}</strong>, tu solicitud para el libro ID 
    <strong>${libroId}</strong> fue realizada con éxito.
</p>

<a href="catalogo" class="btn btn-primary mt-3">Volver al catálogo</a>

</body>
</html>
