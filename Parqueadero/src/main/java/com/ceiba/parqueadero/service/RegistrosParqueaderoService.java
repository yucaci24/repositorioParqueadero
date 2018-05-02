package com.ceiba.parqueadero.service;

import com.ceiba.parqueadero.model.RegistrosParqueadero;
import com.ceiba.parqueadero.model.Vehiculo;

public interface RegistrosParqueaderoService {

	void ingresarVehiculo (RegistrosParqueadero registro,Vehiculo vehiculo) throws Exception;;
	Vehiculo consultarVehiculoPorPlaca (String placa) throws Exception;
	RegistrosParqueadero consultarVehiculoPorEstado (boolean estado);
	int consultarCantidadCarros ();
	int consultarCantidadMotos ();
	long salirVehiculo(RegistrosParqueadero registro, Vehiculo vehiculo) throws Exception;
}
