package com.skillnest.model;

import java.sql.Timestamp;

public class Solicitud {
	private int id;
	private String nombre;
	private String correo;
	private int libroId;
	private Timestamp fechaSolicitud;

	public Solicitud() {
	}

	public Solicitud(int id, String nombre, String correo, int libroId, Timestamp fechaSolicitud) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.libroId = libroId;
		this.fechaSolicitud = fechaSolicitud;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getLibroId() {
		return libroId;
	}

	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}

	public Timestamp getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Timestamp fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
}
