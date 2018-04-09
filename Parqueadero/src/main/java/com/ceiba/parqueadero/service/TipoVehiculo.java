package com.ceiba.parqueadero.service;

public enum TipoVehiculo {
	
	CARRO(1),
	MOTO(2);
	
	private int tipoVehiculo;
	
	private TipoVehiculo(int tipo) {
		this.tipoVehiculo = tipo;
	}
	
	public int getTipoVehiculo() {
		return tipoVehiculo;
	}


}
