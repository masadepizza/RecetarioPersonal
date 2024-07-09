package com.recetario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tipos")
public class Tipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="tipo")
	private String tipo;

	public Tipo(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	
	
	public Tipo() {
		super();
		this.id = 0;
		this.tipo = "";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Tipo [id=" + id + ", tipo=" + tipo + "]";
	}
	
}
