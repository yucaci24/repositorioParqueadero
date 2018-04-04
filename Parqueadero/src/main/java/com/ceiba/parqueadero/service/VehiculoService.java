package com.ceiba.parqueadero.service;


import com.ceiba.parqueadero.model.Parqueadero;
import com.ceiba.parqueadero.model.Vehiculo;

public interface VehiculoService {

	void ingresarVehiculo (Vehiculo vehiculo, Parqueadero parqueadero);
	Vehiculo salirVehiculo (String placa);
	Vehiculo consultarVehiculo (String placa);
	
}
