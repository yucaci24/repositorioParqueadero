package com.ceiba.parqueadero.dao;

import com.ceiba.parqueadero.model.Vehiculo;

public interface VehiculoDao {
	
	void ingresarVehiculo (Vehiculo vehiculo);
	Vehiculo consultarVehiculoPorPlaca (String placa);
	Vehiculo consultarVehiculoPorEstado (boolean estado);
	void salirVehiculo (Vehiculo vehiculo);
	int consultarCantidadCarros ();
	int consultarCantidadMotos ();
}
