CREATE DATABASE IF NOT EXISTS biblioteca CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE biblioteca;

CREATE TABLE IF NOT EXISTS libros (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  autor VARCHAR(255) NOT NULL,
  disponible TINYINT(1) NOT NULL DEFAULT 1,
  imagen VARCHAR(255) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS solicitudes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(200) NOT NULL,
  correo VARCHAR(200) NOT NULL,
  libro_id INT NOT NULL,
  fecha_solicitud TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (libro_id) REFERENCES libros(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  nombre VARCHAR(100)
);


INSERT INTO libros (titulo, autor, disponible, imagen) VALUES
('Clean Code', 'Robert C. Martin', 1, 'img/cleancode.jpg'),
('Programación en Java', 'Herbert Schildt', 1, 'img/java.jpg'),
('Estructuras de Datos', 'A. T. Goodrich', 1, 'img/estructuras.jpg'),
('Redes de Computadoras', 'Andrew S. Tanenbaum', 0, 'img/redes.jpg'),
('Python Crash Course', 'Eric Matthes', 1, 'img/python.jpg'),
('El Quijote', 'Miguel de Cervantes', 1, 'img/quijote.jpg'),
('1984', 'George Orwell', 1, 'img/1984.jpg'),
('Orgullo y Prejuicio', 'Jane Austen', 1, 'img/orgullo.jpg'),
('Crimen y Castigo', 'Fiódor Dostoievski', 0, 'img/crimen.jpg'),
('El Señor de los Anillos', 'J.R.R. Tolkien', 1, 'img/lotr.jpg'),
('Harry Potter y la Piedra Filosofal', 'J.K. Rowling', 1, 'img/hp1.jpg'),
('El Nombre del Viento', 'Patrick Rothfuss', 1, 'img/nombreviento.jpg'),
('Duna', 'Frank Herbert', 1, 'img/duna.jpg'),
('Fundación', 'Isaac Asimov', 1, 'img/fundacion.jpg'),
('Ready Player One', 'Ernest Cline', 1, 'img/rpo.jpg'),
('El Código Da Vinci', 'Dan Brown', 1, 'img/davinci.jpg'),
('La Chica del Tren', 'Paula Hawkins', 0, 'img/chicatren.jpg'),
('Los 7 Hábitos de la Gente Altamente Efectiva', 'Stephen Covey', 1, 'img/7habitos.jpg'),
('Cómo Ganar Amigos e Influir sobre las Personas', 'Dale Carnegie', 1, 'img/ganaramigos.jpg'),
('El Poder del Ahora', 'Eckhart Tolle', 1, 'img/podernow.jpg'),
('Bajo la Misma Estrella', 'John Green', 1, 'img/bajolamismaestrella.jpg'),
('Divergente', 'Veronica Roth', 1, 'img/divergente.jpg'),
('Sapiens: De Animales a Dioses', 'Yuval Noah Harari', 1, 'img/sapiens.jpg'),
('Breve Historia del Tiempo', 'Stephen Hawking', 1, 'img/historiatiempo.jpg'),
('El Resplandor', 'Stephen King', 1, 'img/resplandor.jpg'),
('Drácula', 'Bram Stoker', 0, 'img/dracula.jpg');


INSERT INTO usuarios (username, password, nombre) VALUES
('admin', 'admin123', 'Administrador');
