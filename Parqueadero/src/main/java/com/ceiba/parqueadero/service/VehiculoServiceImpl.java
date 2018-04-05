package com.ceiba.parqueadero.service;

import java.util.Date;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.Vehiculo;

@Service("vehiculoService")
@Transactional
public class VehiculoServiceImpl extends Utils implements VehiculoService{

	@Autowired
	public VehiculoDao vehiculoDao;
	

	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		Date date = new Date();
		String letra = vehiculo.getPlaca();
		int tipo = vehiculo.getTipo();
		if (tipoVehiculo(tipo)==true) {
			if (consultarCantidadCeldasCarro()==true) {
				if ((comprobarLetraInicial(letra)==true)) {
					if (obtenerDia(date)==true) {
						vehiculoDao.ingresarVehiculo(vehiculo);
					}else {
						System.out.println("no puede ingresar");
					}
				}else {
					vehiculoDao.ingresarVehiculo(vehiculo);
				}
			}
			System.out.println("no puede ingresar");
		}else {
			if (consultarCantidadCeldasMoto()==true) {
				if ((comprobarLetraInicial(letra)==true)) {
					if (obtenerDia(date)==true) {
						vehiculoDao.ingresarVehiculo(vehiculo);
					}else {
						System.out.println("no puede ingresar");
					}
				}else  {
					vehiculoDao.ingresarVehiculo(vehiculo);
				}		
			}
		}
	}
	
	
	
	@Override
	public Vehiculo salirVehiculo(String placa) {
		return vehiculoDao.salirVehiculo(placa);
	}

	@Override
	public Vehiculo consultarVehiculo(String placa) {
		return vehiculoDao.consultarVehiculo(placa);
	}
	
	@Override
	public int consultarCantidadCarros() {
		return vehiculoDao.consultarCantidadCarros();
	}

	@Override
	public int consultarCantidadMotos() {
		return vehiculoDao.consultarCantidadMotos();
	}


}