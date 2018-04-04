package com.ceiba.parqueadero.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.parqueadero.dao.ParqueaderoDao;
import com.ceiba.parqueadero.model.Parqueadero;

public class ParqueaderoServiceImpl extends Utils implements ParqueaderoService {
	
	@Autowired
	private ParqueaderoDao parqueaderoDao;

	@Override
	public Parqueadero consultarCeldasMoto(int celdasMoto) {

		return parqueaderoDao.consultarCeldasMoto(celdasMoto);
	}

	@Override
	public Parqueadero consultarCeldasCarro(int celdasCarro) {

		return parqueaderoDao.consultarCeldasCarro(celdasCarro);
	}

	@Override
	public void aumentarCeldasMoto(int celdasMoto) {
		if (sumarCeldasMoto(celdasMoto)) {
			parqueaderoDao.aumentarCeldasMoto(celdasMoto);
		}
	}

	@Override
	public void aumentarCeldasCarro(int celdasCarro) {
		if (sumarCeldasCarro(celdasCarro)) {
			parqueaderoDao.aumentarCeldasCarro(celdasCarro);
		}
	}

	@Override
	public void disminuirCeldasMoto(int celdasMoto) {

		parqueaderoDao.disminuirCeldasMoto(celdasMoto);
	}

	@Override
	public void disminuirCeldasCarro(int celdasCarro) {

		parqueaderoDao.disminuirCeldasCarro(celdasCarro);
	}

}
