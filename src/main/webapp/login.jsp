<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
    <title>Iniciar Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">

<h2>Login</h2>

<c:if test="${not empty error}">
    <div class="alert alert-danger mt-3">${error}</div>
</c:if>

<form action="login" method="post" class="mt-4">

    <div class="mb-3">
        <label class="form-label">Usuario:</label>
        <input type="text" name="username" class="form-control" required />
    </div>

    <div class="mb-3">
        <label class="form-label">Contraseña:</label>
        <input type="password" name="password" class="form-control" required />
    </div>

    <button class="btn btn-primary">Entrar</button>
</form>

</body>
</html>
