package com.ceiba.parqueadero.service;

import java.util.Date;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dao.ParqueaderoDao;
import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.Parqueadero;
import com.ceiba.parqueadero.model.Vehiculo;

@Service("vehiculoService")
@Transactional
public class VehiculoServiceImpl extends Utils implements VehiculoService{

	@Autowired
	public VehiculoDao vehiculoDao;
	public ParqueaderoService parqueaderoService;
	
	
	@Override
	public void ingresarVehiculo(Vehiculo vehiculo, Parqueadero parqueadero) {
		Date date = new Date();
		String letra = vehiculo.getPlaca();
		String tipo = vehiculo.getTipo();
		int celdasCarro = parqueadero.getCeldasCarro();
		int celdasMoto = parqueadero.getCeldasMoto();
		if (condicionesIngreso(vehiculo, celdasCarro, celdasMoto, tipo)) {
			vehiculoDao.ingresarVehiculo(vehiculo);
		}
		
		
		
//		if (tipoVehiculo(tipo)) {
//			parqueaderoService.consultarCeldasCarro(celdasCarro);
//			if ((comprobarLetraInicial(letra)) && (obtenerDia(date))) {
//				vehiculoDao.ingresarVehiculo(vehiculo);
//				if (celdasCarro<20|| celdasCarro>0) {
//					parqueaderoService.aumentarCeldasCarro(celdasCarro);
//				}else {
//					System.out.println("no hay celdas disponibles");
//				}
//			}	
//		} parqueaderoService.consultarCeldasMoto(celdasMoto);
//			if ((comprobarLetraInicial(letra)) && (obtenerDia(date))) {
//					vehiculoDao.ingresarVehiculo(vehiculo);
//					if (celdasMoto<10|| celdasMoto>0) {
//						parqueaderoService.aumentarCeldasMoto(celdasMoto);
//					}else {
//						System.out.println("no hay celdas disponibles");
//					}
//		}
	}
		
	@Override
	public Vehiculo salirVehiculo(String placa) {
		return vehiculoDao.salirVehiculo(placa);
	}

	@Override
	public Vehiculo consultarVehiculo(String placa) {
		return vehiculoDao.consultarVehiculo(placa);
	}
	
}