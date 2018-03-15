package com.ceiba.parqueadero.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "moto")
public class Moto extends Vehiculo{
	
	@Id
	@Column (name = "id_moto")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int idMoto;
	
	@Column (name = "cilindraje")
	public boolean cilindraje;

	public Moto(int idVehiculo, String placa, Date hora, int idMoto, boolean cilindraje) {
		super(idVehiculo, placa, hora);
		this.idMoto = idMoto;
		this.cilindraje = cilindraje;
	}

	public int getIdMoto() {
		return idMoto;
	}

	public void setIdMoto(int idMoto) {
		this.idMoto = idMoto;
	}

	public boolean isCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(boolean cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	
	
}
