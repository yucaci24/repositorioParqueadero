package com.ceiba.parqueadero.service;

public enum TipoVehiculo {
	
	CARRO(1),
	MOTO(2);
	
	private int tipoVehiculoIngreso;
	
	private TipoVehiculo(int tipo) {
		this.tipoVehiculoIngreso = tipo;
	}
	
	public int getTipoVehiculo() {
		return tipoVehiculoIngreso;
	}


}
