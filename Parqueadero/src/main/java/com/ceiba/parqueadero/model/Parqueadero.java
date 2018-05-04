package com.ceiba.parqueadero.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="parqueadero")
public class Parqueadero {
	
	//Attributes
	@Id
	@Column (name="id_registros")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int idRegistros;
	
	@Column (name="fecha_y_hora_entrada")
	public Date fechaYHoraEntrada;
	
	@Column (name="cobro")
	public long cobro;
	
	@Column (name= "id_vehiculo")
	public int idVehiculo;
	
	
	public Parqueadero(long cobro, int idVehiculo) {
		super();
		this.cobro = cobro;
		this.idVehiculo = idVehiculo;
	}


	public Parqueadero() {
		super();
	}

	public int getIdRegistros() {
		return idRegistros;
	}

	public void setIdRegistros(int idRegistros) {
		this.idRegistros = idRegistros;
	}

	public Date getFechaYHoraEntrada() {
		return fechaYHoraEntrada;
	}

	public void setFechaYHoraEntrada(Date fechaYHoraEntrada) {
		this.fechaYHoraEntrada = fechaYHoraEntrada;
	}

	

	public long getCobro() {
		return cobro;
	}

	public void setCobro(long cobro) {
		this.cobro = cobro;
	}
	

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	
	public void agregarDatosAlVehiculo (Vehiculo vehiculo) {
		vehiculo.setId(vehiculo.id);
		vehiculo.setPlaca(vehiculo.placa);
		vehiculo.setCilindraje(vehiculo.cilindraje);;
	}
}
