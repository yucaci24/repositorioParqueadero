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
		if (tipo==1) {
			return true;
		}return false;
	}
	
	public boolean comprobarLetraInicial (String placa) {	
		String primeraLetra = placa.substring(0, 1);
			if (primeraLetra.equals("a")) {
				return true;
			}return false;
	}
	
	public boolean obtenerDia (Date dia){
		GregorianCalendar calendario = new GregorianCalendar();
		calendario.setTime(dia);
		if ((calendario.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY )|| (calendario.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)) {
			return true;
		}return false;
	}
	
	public boolean consultarCantidadCeldasMoto() {
		if (vehiculoDao.consultarCantidadMotos()<10) {
			return true;
		}return false;
	}
	
	public boolean consultarCantidadCeldasCarro() {
		if (vehiculoDao.consultarCantidadCarros()<20) {
			return true;
		}return false;
	}

	public boolean verificarEstado(int estado)	{
		if (estado == 1) {
			return true;
		}return false;
	}
}
