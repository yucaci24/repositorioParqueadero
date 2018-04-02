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
		String letra = new Vehiculo().placa;
		
		//if (ComprobarLetraInicial(letra)== "a") {
//		if (obtenerDiaDeLaSemana(date)==1 || obtenerDiaDeLaSemana(date)==2 ) {
//			_vehiculoDao.ingresarVehiculo(vehiculo);
//			}else {
//				System.out.println("las placas que inician por la letra A, solo pueden ingresar domingo y lunes");
//			}
//		}
			
		_vehiculoDao.ingresarVehiculo(vehiculo);
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