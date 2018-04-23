package com.ceiba.parqueadero.service;

import java.util.Date;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.Vehiculo;

@Service("vehiculoService")
@Transactional
public class VehiculoServiceImpl implements VehiculoService{

	@Autowired
	public VehiculoDao vehiculoDao;
	
	@Autowired
	public ComprobacionesEntradaYSalidaVehiculos validaciones;
	
	CalculadoraCobro cobro = new CalculadoraCobro();
	

	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) throws Exception {
		Date date = new Date();
		
		if (!validaciones.consultarCantidadCeldas( vehiculo.getTipo() )) {
			throw new Exception("No hay celdas Disponibles");
		}
		
		if(!validaciones.validoIngresarVehiculo(vehiculo.getPlaca(), date) ) {
			throw new Exception("No puede ingresar");
		}
		
		vehiculoDao.ingresarVehiculo(vehiculo);
		
	}
	
	@Override
	public long salirVehiculo(Vehiculo vehiculo) {
		CalculadoraCobro calculadoraC = new CalculadoraCobro();
		long valorTotal = calculadoraC.calcularValorSalidaTotal(vehiculo);
		vehiculo.setCobro(valorTotal);
		vehiculoDao.salirVehiculo(vehiculo);
		System.out.println("el cobro es: "+valorTotal);
		return valorTotal;
	}

	@Override
	public Vehiculo consultarVehiculoPorPlaca(String placa) {
		return vehiculoDao.consultarVehiculoPorPlaca(placa);
	}
	
	@Override
	public Vehiculo consultarVehiculoPorEstado(boolean estado) {
		return vehiculoDao.consultarVehiculoPorEstado(estado);
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