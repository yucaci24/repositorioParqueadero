package com.ceiba.parqueadero.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parqueo")

public class Vehiculo implements Serializable{
	

	//Attributes
	@Id
	@Column (name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@Column (name="placa")
	public String placa;
	
	@Column (name="tipo_de_vehiculo", nullable= true)
	public String tipo;
	
	@Column (name="cilindraje", nullable= true)
	public int cilindraje;
	
	@Column (name="fecha_y_hora_entrada")
	public Date fechaYHoraEntrada;
	

	
	public Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Constructor
	public Vehiculo(String placa) {
		this.placa = placa;
	}
	
	//Getters and setters
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Date getFechaYHoraEntrada() {
		return fechaYHoraEntrada;
	}

	public void setFechaYHoraEntrada(Date fechaYHoraEntrada) {
		this.fechaYHoraEntrada = fechaYHoraEntrada;
	}

}
