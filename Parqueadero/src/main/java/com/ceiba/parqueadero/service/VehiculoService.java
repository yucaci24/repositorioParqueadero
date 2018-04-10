package com.ceiba.parqueadero.service;

import com.ceiba.parqueadero.model.Vehiculo;

public interface VehiculoService {

	void ingresarVehiculo (Vehiculo vehiculo) throws Exception;
	long salirVehiculo (Vehiculo vehiculo);
	Vehiculo consultarVehiculoPorPlaca (String placa);
	Vehiculo consultarVehiculoPorEstado (boolean estado);
	int consultarCantidadCarros ();
	int consultarCantidadMotos ();
}
