package com.ceiba.parqueadero.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "carro")
public class Carro extends Vehiculo{
	
	@Id
	@Column(name="id_carro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int idCarro;
	
	public Carro(int idVehiculo, String placa, Date hora) {
		super(idVehiculo, placa, hora);
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	

	
}
