package com.ceiba.parqueadero.dao;

import java.util.Date;

import com.ceiba.parqueadero.model.Moto;

public interface MotoDao {

	void ingresarMoto(Moto moto);
	void salirMoto (Moto moto);
	Moto consultarMoto (String placa, Date hora);
	
}
