package com.ceiba.parqueadero.dao;

import com.ceiba.parqueadero.model.ReciboPago;
import com.ceiba.parqueadero.model.Vehiculo;

public interface VehiculoDao {
	
	void ingresarVehiculo (Vehiculo vehiculo);
	Vehiculo consultarVehiculoPorPlaca (String placa);
	void salirVehiculo (ReciboPago recibo);
	Vehiculo consultarVehiculoId (int id);
}
