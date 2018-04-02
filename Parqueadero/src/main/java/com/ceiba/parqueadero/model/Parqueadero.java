package com.ceiba.parqueadero.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Parqueadero implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//Attributes
	@Id
	@Column (name="id_celdas")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int idCeldas;
	
	@Column (name="celdas_moto")
	public int celdasMoto;
	
	@Column (name="celdas_carro")
	public int celdasCarro;

	//constructor
	public Parqueadero() {
		super();
	}

	//Getters and setters
	public int getIdCeldas() {
		return idCeldas;
	}

	public void setIdCeldas(int idCeldas) {
		this.idCeldas = idCeldas;
	}

	public int getCeldasMoto() {
		return celdasMoto;
	}

	public void setCeldasMoto(int celdasMoto) {
		this.celdasMoto = celdasMoto;
	}

	public int getCeldasCarro() {
		return celdasCarro;
	}

	public void setCeldasCarro(int celdasCarro) {
		this.celdasCarro = celdasCarro;
	}
	
	
}
