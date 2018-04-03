package com.ceiba.parqueadero.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.parqueadero.model.Vehiculo;


public class Utils {

	public boolean obtenerDia (Date dia){
		GregorianCalendar calendario = new GregorianCalendar();
		calendario.setTime(dia);
		if ((calendario.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY )|| (calendario.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)) {
			return true;
		}return false;
	}
	
	public boolean comprobarLetraInicial (String placa) {	
		String primeraLetra = placa.substring(0, 1);
		if (primeraLetra.equals("a")) {
			return true;
		}return false;
	}
	
//	public int cobrarMoto (Date fechaEntrada, Date fechaSalida) {
//		
//		long diferencia =  fechaEntrada.getTime()- fechaSalida.getTime();
//		int cobro=0;
//		
//		return (int) diferencia;
//	}
//	
//	public int aumentarCeldas (int disponiblesCarro, int disponiblesMoto) {
//		return int;
//	}
//	
//	public int disminuirCeldas (int disponiblesCarro, int disponiblesMoto) {
//		return
//	}
	
}
