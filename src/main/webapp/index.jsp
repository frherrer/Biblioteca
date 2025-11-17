<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Catálogo de Libros</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">

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

    

    <div class="row">
 
  
<c:if test="${empty libros}">
    <div class="col-12 text-center mt-3">
        <a href="catalogo" class="btn btn-primary">Ver catálogo</a>
    </div>
</c:if>

<c:if test="${not empty libros}">
    <h2 class="mb-4 text-center">Catálogo de Libros</h2>
</c:if>
  
  
       <c:forEach var="libro" items="${libros}">

           
            <div class="col-md-4 mb-4">
                <div class="card shadow-sm" style="min-height: 550px;">

                    <img src="${pageContext.request.contextPath}/${libro.imagen}" 
                         class="card-img-top" 
                         style="height: 300px; object-fit: cover;">

                    <div class="card-body">

                        <h5 class="card-title">${libro.titulo}</h5>
                        <p class="text-muted">Autor: ${libro.autor}</p>

                                               <p>
                            <c:choose>
                                <c:when test="${libro.disponible}">
                                    <span class="badge bg-success">Disponible</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge bg-danger">No disponible</span>
                                </c:otherwise>
                            </c:choose>
                        </p>

                       
                        <c:if test="${libro.disponible}">
                            <a href="${pageContext.request.contextPath}/solicitud.jsp?id=${libro.id}" 
                               class="btn btn-primary w-100">
                                Solicitar Préstamo
                            </a>
                        </c:if>

                     
                        <c:if test="${not libro.disponible}">
                            <button class="btn btn-secondary w-100" disabled>
                                No disponible
                            </button>
                        </c:if>

                    </div>
                </div>
            </div>

        </c:forEach>
    </div>

</div>

</body>
</html>
