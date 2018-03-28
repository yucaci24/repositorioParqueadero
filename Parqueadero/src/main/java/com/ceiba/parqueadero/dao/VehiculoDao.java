package com.ceiba.parqueadero.dao;

import com.ceiba.parqueadero.model.Vehiculo;

public interface VehiculoDao {
	
	void ingresarVehiculo (Vehiculo vehiculo);
	Vehiculo consultarVehiculo (String placa);
	Vehiculo salirVehiculo (String placa);
}
