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
@Table (name = "vehiculo")
public class Vehiculo implements Serializable{
	
	@Id
	@Column (name = "id_vehiculo")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int idVehiculo;
	
	@Column (name = "placa")
	public String placa;
	
	@Column(name = "hora")
	public Date hora;

	public Vehiculo(int idVehiculo, String placa, Date hora) {
		super();
		this.idVehiculo = idVehiculo;
		this.placa = placa;
		this.hora = hora;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	
	
}
