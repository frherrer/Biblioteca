# 📚 Biblioteca Universitaria -- Aplicación Web Java EE

Aplicación web dinámica desarrollada en **Java EE con arquitectura
MVC**, cuyo objetivo es permitir a los usuarios consultar el catálogo de
libros de una biblioteca universitaria y registrar solicitudes de
préstamo.\
El proyecto está diseñado para ejecutarse en un servidor **Apache
Tomcat** e integra acceso a datos mediante JDBC y el patrón **DAO**.

## 📌 Características principales

✔️ Listado de libros disponibles en la biblioteca\
✔️ Formulario para registrar solicitudes de préstamo\
✔️ Almacenamiento de solicitudes en base de datos\
✔️ Página de administración con listado de solicitudes\
✔️ Arquitectura en capas con separación clara MVC\
✔️ Despliegue mediante archivo **WAR**\
✔️ Uso de JSP para las vistas y Servlets como controladores

## 🖼️ Capturas de pantalla

### Catálogo de Libros

`<img src="img/catalogo.png" width="500">`{=html}

### Página de Inicio

`<img src="img/index.png" width="500">`{=html}

## 📁 Estructura del Proyecto

    Biblioteca/
    │
    ├── Biblioteca.war
    │
    ├── src/
    │   └── com/skillnest/
    │       ├── util/
    │       │   └── ConexionDB.java
    │       │
    │       ├── model/
    │       │   ├── Libro.java
    │       │   ├── Solicitud.java
    │       │   └── Usuario.java
    │       │
    │       ├── dat/
    │       │   ├── LibroDAO.java
    │       │   ├── SolicitudDAO.java
    │       │   └── UsuarioDAO.java
    │       │
    │       └── controller/
    │           ├── AdminServlet.java
    │           ├── CatalogoServlet.java
    │           ├── LoginServlet.java
    │           ├── LogoutServlet.java
    │           └── SolicitudServlet.java
    │
    └── webapp/
        ├── index.jsp
        ├── solicitud.jsp
        ├── confirmacion.jsp
        ├── admin.jsp
        ├── login.jsp
        └── img/
            └── (miniaturas del catálogo)

## 🧱 Arquitectura (Modelo--Vista--Controlador)

### Modelo

Incluye clases de dominio y DAO conectados mediante JDBC.

### Vista

JSP ubicadas en `/webapp/` que reciben datos mediante
`request.setAttribute()`.

### Controlador

Servlets que manejan la lógica de negocio y flujo entre vistas y modelo.

## 🗄️ Base de Datos

Ejemplo para MySQL:

``` sql
CREATE TABLE libros (
  id INT PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(100),
  autor VARCHAR(100),
  disponible BOOLEAN
);

CREATE TABLE solicitudes (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100),
  correo VARCHAR(100),
  libro_id INT,
  fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

Configurar `ConexionDB.java` con tus credenciales.

## 🚀 Cómo ejecutar el proyecto

### 1. Configurar base de datos

Crear BD y ejecutar tablas.

### 2. Ajustar credenciales en `ConexionDB.java`.

### 3. Desplegar en Tomcat

Mover `Biblioteca.war` a `webapps/` o ejecutar desde IDE.

## 🌐 URLs principales

-   Catálogo: `http://localhost:8080/Biblioteca/`
-   Solicitud: `http://localhost:8080/Biblioteca/solicitud.jsp`
-   Administración: `http://localhost:8080/Biblioteca/admin`

## 📄 Licencia

Agregar la que necesites (MIT, GPL, etc.).
