package com.ceiba.parqueadero.service;

import java.util.Date;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dao.RegistrosParqueaderoDao;
import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.RegistrosParqueadero;
import com.ceiba.parqueadero.model.Vehiculo;

@Service("vehiculoService")
@Transactional
public class RegistrosParqueaderoServiceImpl implements RegistrosParqueaderoService{

	@Autowired
	public VehiculoDao vehiculoDao;
	
	@Autowired
	public RegistrosParqueaderoDao registrosParqueaderoDao;
	
	@Autowired
	public ComprobacionesEntradaYSalidaVehiculos validaciones;
	
	CalculadoraCobro cobro = new CalculadoraCobro();
	

	@Override
	public void ingresarVehiculo(RegistrosParqueadero registro, Vehiculo vehiculo) throws Exception {
		Date date = new Date();
	
		if (!validaciones.consultarCantidadCeldas( registro.getTipo() )) {
			throw new Exception("No hay celdas Disponibles");
		}
		
		if (vehiculo.getPlaca()==(null) ||vehiculo.getPlaca().isEmpty() ) {
		throw new Exception("Debe ingresar una placa");
		}
		
		if(!validaciones.validoIngresarVehiculo(vehiculo.getPlaca(), date) ) {
			throw new Exception("No puede ingresar");
		}
		
		vehiculoDao.ingresarVehiculo(vehiculo);
		registrosParqueaderoDao.ingresarVehiculo(registro);
		
	}
	
	@Override
	public long salirVehiculo(RegistrosParqueadero registro, Vehiculo vehiculo) throws Exception {
		CalculadoraCobro calculadoraC = new CalculadoraCobro();
		long valorTotal = calculadoraC.calcularValorSalidaTotal(registro, vehiculo);
		registro.setCobro(valorTotal);
		
		
		if (vehiculo.getPlaca() == null) {
			throw new Exception("Debe ingresar una placa");
		}
		if (vehiculoDao.consultarVehiculoPorPlaca(vehiculo.getPlaca())==null) {
			throw new Exception("El Vehiculo No Esta En El Parqueadero");
		}
		vehiculoDao.salirVehiculo(vehiculo);
		System.out.println("el cobro es: "+valorTotal);
		return valorTotal;
	}

	@Override
	public Vehiculo consultarVehiculoPorPlaca(String placa) throws Exception {
		if (placa == null) {
			throw new Exception("Debe ingresar una placa");
		}
		return vehiculoDao.consultarVehiculoPorPlaca(placa);
	}
	
	@Override
	public RegistrosParqueadero consultarVehiculoPorEstado(boolean estado) {
		return registrosParqueaderoDao.consultarVehiculoPorEstado(estado);
	}
	
	@Override
	public int consultarCantidadCarros() {
		return registrosParqueaderoDao.consultarCantidadCarros();
	}

	@Override
	public int consultarCantidadMotos() {
		return registrosParqueaderoDao.consultarCantidadMotos();
	}
}