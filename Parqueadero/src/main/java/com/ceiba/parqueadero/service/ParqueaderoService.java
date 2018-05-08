package com.ceiba.parqueadero.service;

import com.ceiba.parqueadero.model.ReciboPago;
import com.ceiba.parqueadero.model.Vehiculo;

public interface ParqueaderoService {

	Vehiculo ingresarVehiculo (Vehiculo vehiculo) throws Exception;;
	ReciboPago consultarVehiculoPorPlaca (String placa) throws Exception;
	int consultarCantidadCarros ();
	int consultarCantidadMotos ();
	ReciboPago salirVehiculo( ReciboPago recibo) throws Exception;
	
}
