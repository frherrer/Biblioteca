package com.skillnest.model;

public class Libro {
	private int id;
	private String titulo;
	private String autor;
	private boolean disponible;
	private String imagen;

	public Libro() {
	}

	public Libro(int id, String titulo, String autor, boolean disponible,String imagen) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.disponible = disponible;
		this.imagen =imagen;
	}
	

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
