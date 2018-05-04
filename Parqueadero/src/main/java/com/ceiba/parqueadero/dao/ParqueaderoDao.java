package com.ceiba.parqueadero.dao;

import com.ceiba.parqueadero.model.Parqueadero;
import com.ceiba.parqueadero.model.ReciboPago;

public interface ParqueaderoDao {

	ReciboPago consultarVehiculoPorEstado (boolean estado);
	int consultarCantidadCarros ();
	int consultarCantidadMotos ();
	int consultarCantidadCeldas( int tipoVehiculo );
	void salirVehiculo(Parqueadero registro);
	void ingresarVehiculo(Parqueadero registro);
	Parqueadero consultarRegistroIdVehiculo (int idVehiculo);
	
}
