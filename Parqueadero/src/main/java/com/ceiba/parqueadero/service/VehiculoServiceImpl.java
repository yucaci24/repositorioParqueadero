package com.ceiba.parqueadero.service;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.Vehiculo;

@Service("vehiculoService")
@Transactional
public class VehiculoServiceImpl implements VehiculoService{

	@Autowired
	public VehiculoDao _vehiculoDao;
	public int precio;
	
	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		
		_vehiculoDao.ingresarVehiculo(vehiculo);
	}

	@Override
	public Vehiculo salirVehiculo(String placa) {
		// TODO Auto-generated method stub
		return _vehiculoDao.salirVehiculo(placa);
	}

	@Override
	public Vehiculo consultarVehiculo(String placa) {
		// TODO Auto-generated method stub
		return _vehiculoDao.consultarVehiculo(placa);
}
}