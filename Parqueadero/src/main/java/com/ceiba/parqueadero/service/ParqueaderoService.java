package com.ceiba.parqueadero.service;

import com.ceiba.parqueadero.model.ReciboPago;
import com.ceiba.parqueadero.model.Parqueadero;
import com.ceiba.parqueadero.model.Vehiculo;

public interface ParqueaderoService {

	void ingresarVehiculo (Vehiculo vehiculo) throws Exception;;
	ReciboPago consultarVehiculoPorPlaca (String placa) throws Exception;
	ReciboPago consultarVehiculoPorEstado (boolean estado);
	int consultarCantidadCarros ();
	int consultarCantidadMotos ();
	void salirVehiculo( ReciboPago recibo) throws Exception;
	
}
