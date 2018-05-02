package com.ceiba.parqueadero.dao;

import com.ceiba.parqueadero.model.RegistrosParqueadero;

public interface RegistrosParqueaderoDao {

	RegistrosParqueadero consultarVehiculoPorEstado (boolean estado);
	int consultarCantidadCarros ();
	int consultarCantidadMotos ();
	int consultarCantidadCeldas( int tipoVehiculo );
	void salirVehiculo(RegistrosParqueadero registro);
	void ingresarVehiculo(RegistrosParqueadero registro);
	
}
