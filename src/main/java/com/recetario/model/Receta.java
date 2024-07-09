package com.recetario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="recetas")
public class Receta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombreReceta")
	private String nombreReceta;
	
	@Column(name="ingredientes")
	private String ingredientes;
	
	@ManyToOne
	private Dificultad dificultad;
	
	@ManyToOne
	private Tipo tipo;

    @Column(name="imagenUrl")
    private String imagenUrl;
    
    @Column(name="duracion")
    private String duracion;
    
    @ManyToOne
    private Racion racion;
    
    @Column(name="paso1")
    private String paso1;
    
    @Column(name="paso2")
    private String paso2;
    
    @Column(name="paso3")
    private String paso3;
    
    @Column(name="paso4")
    private String paso4;
    
    @Column(name="paso5")
    private String paso5;
    
    @Column(name="paso6")
    private String paso6;
    
    @Column(name="paso7")
    private String paso7;
    
    @Column(name="paso8")
    private String paso8;
    
    @Column(name="paso9")
    private String paso9;
    
    @Column(name="paso10")
    private String paso10;

	public Receta(int id, String nombreReceta, String ingredientes, Dificultad dificultad, Tipo tipo, String imagenUrl,
			String duracion, Racion racion, String paso1, String paso2, String paso3, String paso4, String paso5,
			String paso6, String paso7, String paso8, String paso9, String paso10) {
		super();
		this.id = id;
		this.nombreReceta = nombreReceta;
		this.ingredientes = ingredientes;
		this.dificultad = dificultad;
		this.tipo = tipo;
		this.imagenUrl = imagenUrl;
		this.duracion = duracion;
		this.racion = racion;
		this.paso1 = paso1;
		this.paso2 = paso2;
		this.paso3 = paso3;
		this.paso4 = paso4;
		this.paso5 = paso5;
		this.paso6 = paso6;
		this.paso7 = paso7;
		this.paso8 = paso8;
		this.paso9 = paso9;
		this.paso10 = paso10;
	}

	public Receta() {
		super();
		this.id = 0;
		this.nombreReceta = "";
		this.ingredientes = "";
		this.dificultad = new Dificultad();
		this.tipo = new Tipo();
		this.imagenUrl = "";
		this.duracion = "";
		this.racion = new Racion();
		this.paso1 = "";
		this.paso2 = "";
		this.paso3 = "";
		this.paso4 = "";
		this.paso5 = "";
		this.paso6 = "";
		this.paso7 = "";
		this.paso8 = "";
		this.paso9 = "";
		this.paso10 = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreReceta() {
		return nombreReceta;
	}

	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Racion getRacion() {
		return racion;
	}

	public void setRacion(Racion racion) {
		this.racion = racion;
	}

	public String getPaso1() {
		return paso1;
	}

	public void setPaso1(String paso1) {
		this.paso1 = paso1;
	}

	public String getPaso2() {
		return paso2;
	}

	public void setPaso2(String paso2) {
		this.paso2 = paso2;
	}

	public String getPaso3() {
		return paso3;
	}

	public void setPaso3(String paso3) {
		this.paso3 = paso3;
	}

	public String getPaso4() {
		return paso4;
	}

	public void setPaso4(String paso4) {
		this.paso4 = paso4;
	}

	public String getPaso5() {
		return paso5;
	}

	public void setPaso5(String paso5) {
		this.paso5 = paso5;
	}

	public String getPaso6() {
		return paso6;
	}

	public void setPaso6(String paso6) {
		this.paso6 = paso6;
	}

	public String getPaso7() {
		return paso7;
	}

	public void setPaso7(String paso7) {
		this.paso7 = paso7;
	}

	public String getPaso8() {
		return paso8;
	}

	public void setPaso8(String paso8) {
		this.paso8 = paso8;
	}

	public String getPaso9() {
		return paso9;
	}

	public void setPaso9(String paso9) {
		this.paso9 = paso9;
	}

	public String getPaso10() {
		return paso10;
	}

	public void setPaso10(String paso10) {
		this.paso10 = paso10;
	}

	@Override
	public String toString() {
		return "Receta [id=" + id + ", nombreReceta=" + nombreReceta + ", ingredientes=" + ingredientes
				+ ", dificultad=" + dificultad + ", tipo=" + tipo + ", imagenUrl=" + imagenUrl + ", duracion="
				+ duracion + ", racion=" + racion + ", paso1=" + paso1 + ", paso2=" + paso2 + ", paso3=" + paso3
				+ ", paso4=" + paso4 + ", paso5=" + paso5 + ", paso6=" + paso6 + ", paso7=" + paso7 + ", paso8=" + paso8
				+ ", paso9=" + paso9 + ", paso10=" + paso10 + "]";
	}
	
	
	
	
}
