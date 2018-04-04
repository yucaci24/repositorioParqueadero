package com.ceiba.parqueadero.service;

import com.ceiba.parqueadero.model.Parqueadero;

public interface ParqueaderoService {
	
	Parqueadero consultarCeldasMoto (int celdasMoto);
	Parqueadero consultarCeldasCarro (int celdasCarro);
	void aumentarCeldasMoto (int celdasMoto);
	void aumentarCeldasCarro (int celdasCarro);
	void disminuirCeldasMoto (int celdasMoto);
	void disminuirCeldasCarro (int celdasCarro);
}
