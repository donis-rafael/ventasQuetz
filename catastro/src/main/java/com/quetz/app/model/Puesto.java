package com.quetz.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="puesto")
public class Puesto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="deuda")
	private double Deuda;
	
	@Column(name="fechaDeuda")
	private Date Fecha;
	
	@ManyToOne
	@JoinColumn(name="mercado")
	private Mercado Mercado;
	
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoria;
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getDeuda() {
		return Deuda;
	}
	
	public void setDeuda(double deuda) {
		Deuda = deuda;
	}
	
	public Date getFecha() {
		return Fecha;
	}
	
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	
	public Mercado getMercado() {
		return Mercado;
	}
	
	public void setMercado(Mercado mercado) {
		Mercado = mercado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Puesto [Id=" + Id + ", nombre=" + nombre + ", Deuda=" + Deuda + ", Fecha=" + Fecha + ", Mercado="
				+ Mercado + ", categoria=" + categoria + "]";
	}
}
