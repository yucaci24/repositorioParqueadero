package com.ceiba.parqueadero.model;

import java.util.Date;

public class ReciboPago {

	private String placa;
	private boolean estado;
	private int cilindraje;
	private Date fechaEntrada;
	private long cobro;
	
	public ReciboPago(String placa, boolean estado, int cilindraje, Date fechaEntrada,  long cobro) {
		super();
		this.placa = placa;
		this.estado = estado;
		this.cilindraje = cilindraje;
		this.fechaEntrada = fechaEntrada;
		this.cobro = cobro;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}


	public long getCobro() {
		return cobro;
	}

	public void setCobro(long cobro) {
		this.cobro = cobro;
	}
	
	
}
