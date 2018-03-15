package com.ceiba.parqueadero.dao;

import java.util.Date;

import com.ceiba.parqueadero.model.Carro;

public interface CarroDao {
	
	void ingresarCarro(Carro carro);
	void salirCarro (Carro carro);
	Carro consultarCarro (String placa, Date hora);

}
