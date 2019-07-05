package com.quetz.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="califica")
public class Califica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	private int punteo;
	
	@ManyToOne
	@JoinColumn(name="puesto")
	private Puesto puesto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPunteo() {
		return punteo;
	}

	public void setPunteo(int punteo) {
		this.punteo = punteo;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return "Califica [id=" + id + ", punteo=" + punteo + ", puesto=" + puesto + "]";
	}
}
