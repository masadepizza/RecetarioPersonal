package com.recetario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "raciones")
public class Racion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="raciones")
	private int raciones;

	public Racion(int id, int raciones) {
		super();
		this.id = id;
		this.raciones = raciones;
	}
	
	public Racion() {
		super();
		this.id = 0;
		this.raciones = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRaciones() {
		return raciones;
	}

	public void setRaciones(int raciones) {
		this.raciones = raciones;
	}

	@Override
	public String toString() {
		return "Racion [id=" + id + ", raciones=" + raciones + "]";
	}
	
}
