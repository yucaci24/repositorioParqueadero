package com.ceiba.parqueadero.service;

import java.util.Date;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.Parqueadero;
import com.ceiba.parqueadero.model.Vehiculo;

@Service("vehiculoService")
@Transactional
public class VehiculoServiceImpl extends Utils implements VehiculoService{

	@Autowired
	public VehiculoDao _vehiculoDao;
	public Parqueadero _parqueaderoDao;
	
	
	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		Date date = new Date();
		String letra = vehiculo.getPlaca();
		if ((comprobarLetraInicial(letra)) && (obtenerDia(date))) {
				_vehiculoDao.ingresarVehiculo(vehiculo);
		}
	}
		
	@Override
	public Vehiculo salirVehiculo(String placa) {
		return _vehiculoDao.salirVehiculo(placa);
	}

	@Override
	public Vehiculo consultarVehiculo(String placa) {
		return _vehiculoDao.consultarVehiculo(placa);
	}
	
}