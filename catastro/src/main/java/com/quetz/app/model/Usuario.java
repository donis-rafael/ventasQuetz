package com.quetz.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;

	@Column(name="nombre")
	private String Nombre;

	@Column(name="nombre2")
	private String Nombre2;

	@Column(name="ape")
	private String Apellido;

	@Column(name="ape2")
	private String Apellido2;

	@Column(name="estado")
	private int Estado;

	@Column(name="usuario")
	private String Usuario;

	@Column(name="contra")
	private String Contrasenia;

	@ManyToOne
	@JoinColumn(name="rol")
	private Rol rol;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getNombre2() {
		return Nombre2;
	}
	public void setNombre2(String nombre2) {
		Nombre2 = nombre2;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getApellido2() {
		return Apellido2;
	}
	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getContrasenia() {
		return Contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	@Override
	public String toString() {
		return "Usuario [Id=" + Id + ", Nombre=" + Nombre + ", Nombre2=" + Nombre2 + ", Apellido=" + Apellido
				+ ", Apellido2=" + Apellido2 + ", Estado=" + Estado + ", Usuario=" + Usuario + ", Contrasenia="
				+ Contrasenia + ", rol=" + rol + "]";
	}
}
