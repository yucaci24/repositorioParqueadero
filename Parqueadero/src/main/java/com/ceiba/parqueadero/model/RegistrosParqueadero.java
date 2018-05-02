package com.ceiba.parqueadero.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name="parqueadero")
public class RegistrosParqueadero {
	
	//Attributes
	@Id
	@Column (name="id_registros")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int idRegistros;
	
	@Column (name="fecha_y_hora_entrada")
	public Date fechaYHoraEntrada;
	
	@Column (name="estado")
	public boolean estado;
	
	@Column (name="cobro")
	public long cobro;
	
	@Column (name="tipo_de_vehiculo", nullable= true)
	public int tipo;
	
	@Column (name= "id_vehiculo")
	public int idVehiculo;

	public RegistrosParqueadero() {
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public long getCobro() {
		return cobro;
	}

	public void setCobro(long cobro) {
		this.cobro = cobro;
	}
	

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

}
