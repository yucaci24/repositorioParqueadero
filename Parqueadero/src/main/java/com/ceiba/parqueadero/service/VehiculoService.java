package com.ceiba.parqueadero.service;

import com.ceiba.parqueadero.model.Vehiculo;

public interface VehiculoService {

	void ingresarVehiculo (Vehiculo vehiculo);
	Vehiculo salirVehiculo (String placa);
	Vehiculo consultarVehiculo (String placa);
	int consultarCantidadCarros ();
	int consultarCantidadMotos ();
}
