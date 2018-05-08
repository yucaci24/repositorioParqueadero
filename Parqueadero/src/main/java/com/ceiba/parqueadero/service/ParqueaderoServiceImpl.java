package com.ceiba.parqueadero.service;

import java.util.Date;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dao.ParqueaderoDao;
import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.ReciboPago;
import com.ceiba.parqueadero.model.Parqueadero;
import com.ceiba.parqueadero.model.Vehiculo;

@Service("vehiculoService")
@Transactional
public class ParqueaderoServiceImpl implements ParqueaderoService{

	@Autowired
	public VehiculoDao vehiculoDao;
	
	@Autowired
	public ParqueaderoDao ParqueaderoDao;
	
	@Autowired
	public ComprobacionesEntradaYSalidaVehiculos validaciones;
	
	CalculadoraCobro cobro = new CalculadoraCobro();
	

	@Override
	public Vehiculo ingresarVehiculo(Vehiculo vehiculo) throws Exception {
		Date date = new Date();
	
		if (!validaciones.consultarCantidadCeldas( vehiculo.getTipo() )) {
			throw new Exception("No hay celdas Disponibles");
		}
		
		if (vehiculo.getPlaca()==(null) ||vehiculo.getPlaca().isEmpty() ) {
			throw new Exception("Debe ingresar una placa");
		}
		
		if(!validaciones.validoIngresarVehiculo(vehiculo.getPlaca(), date) ) {
			throw new Exception("No puede ingresar");
		}
		
		vehiculoDao.ingresarVehiculo(vehiculo);
		realizarRegistro(vehiculo);
		
		return vehiculo;
	}
	
	@Override
	public ReciboPago salirVehiculo(ReciboPago recibo) throws Exception {
		if (vehiculoDao.consultarVehiculoPorPlaca(recibo.getPlaca())==null) {
			throw new Exception("El Vehiculo No Esta En El Parqueadero");
		}
		vehiculoDao.salirVehiculo(recibo);
		return recibo;
	}

	@Override
	public ReciboPago consultarVehiculoPorPlaca(String placa) throws Exception {
		Vehiculo vehiculo = vehiculoDao.consultarVehiculoPorPlaca(placa);
		Parqueadero registro = consultarRegistroIdVehiculo(vehiculo.getId());
		CalculadoraCobro calculadoraC = new CalculadoraCobro();
		long valorTotal = calculadoraC.calcularValorSalidaTotal(registro, vehiculo);
		registro.setCobro(valorTotal);
		
		if (placa == null) {
			throw new Exception("Debe ingresar una placa");
		}
		ReciboPago recibo = new ReciboPago(vehiculo.getPlaca(), 
										   vehiculo.isEstado(),
										   vehiculo.getCilindraje(),
										   registro.getFechaYHoraEntrada(), 
										   valorTotal);
		return recibo;
	}
	

	private void realizarRegistro (Vehiculo vehiculo) {
		Parqueadero registrosParqueadero = new Parqueadero( 0, vehiculo.getId());
		ParqueaderoDao.ingresarVehiculo(registrosParqueadero);
	}
	
	public Parqueadero consultarRegistroIdVehiculo (int idVehiculo) {
		return ParqueaderoDao.consultarRegistroIdVehiculo(idVehiculo);
	}
	
	@Override
	public int consultarCantidadCarros() {
		return ParqueaderoDao.consultarCantidadCarros();
	}

	@Override
	public int consultarCantidadMotos() {
		return ParqueaderoDao.consultarCantidadMotos();
	}
}