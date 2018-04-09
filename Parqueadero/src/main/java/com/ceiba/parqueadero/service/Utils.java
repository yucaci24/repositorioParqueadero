package com.ceiba.parqueadero.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.Vehiculo;

@Service
@Transactional
public class Utils {
	
	@Autowired
	public VehiculoDao vehiculoDao;
	
	public boolean tipoVehiculo (int tipo) {
		return tipo == TipoVehiculo.CARRO.getTipoVehiculo();
	}
	
	//condiciones de ingreso
	
	public boolean comprobarLetraInicial (String placa) {	
		String primeraLetra = placa.substring(0, 1);
			if (primeraLetra.equals("a")) {
				return true;
			}return false;
	}
	
	public boolean obtenerDia (Date dia){
		GregorianCalendar calendario = new GregorianCalendar();
		calendario.setTime(dia);
		if ((calendario.get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY )|| (calendario.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)) {
			return true;
		}return false;
	}
	
	public boolean consultarCantidadCeldas(int tipoVehiculo) {
		boolean hayEspacio = false;
		if( tipoVehiculo == TipoVehiculo.CARRO.getTipoVehiculo() ) {
			hayEspacio = vehiculoDao.consultarCantidadCeldas( tipoVehiculo ) < ConfiguracionParqueadero.CELDAS_CARROS;
		}else {
			hayEspacio = vehiculoDao.consultarCantidadCeldas( tipoVehiculo ) < ConfiguracionParqueadero.CELDAS_MOTOS;		
		}
		return hayEspacio;
		
	}

	public boolean verificarEstado(int estado)	{
		return estado == 1;
	}
	
//	public boolean condicionLetraIngreso (String letra, Date date) {
//		if ((comprobarLetraInicial(letra))) {
//			if (obtenerDia(date)) {
//			}else {
//				System.out.println("no puede ingresar");
//			}
//		}else {
//			
//		}
//		return false;
//	}
	
	//cobro
	
	public boolean verificarCilindraje(int cilindraje) {
			return cilindraje >500;
	}
	
}
