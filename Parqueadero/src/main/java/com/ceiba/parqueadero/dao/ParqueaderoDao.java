package com.ceiba.parqueadero.dao;

import com.ceiba.parqueadero.model.Parqueadero;

public interface ParqueaderoDao {
	
	Parqueadero consultarCeldasMoto (int celdasMoto);
	Parqueadero consultarCeldasCarro (int celdasCarro);
	void aumentarCeldasMoto (int celdasMoto);
	void aumentarCeldasCarro (int celdasCarro);
	void disminuirCeldasMoto (int celdasMoto);
	void disminuirCeldasCarro (int celdasCarro);
}
