package com.quetz.app.util;

public class Punteo {

	private int punteo;
	private String descripcion;
	
	public Punteo(int punteo, String desc) {
		this.punteo = punteo;
		descripcion = desc;
	}

	public int getPunteo() {
		return punteo;
	}

	public void setPunteo(int punteo) {
		this.punteo = punteo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
