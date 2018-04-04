package com.ceiba.parqueadero.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.parqueadero.dao.VehiculoDao;
import com.ceiba.parqueadero.model.Vehiculo;


public class Utils {
	
	@Autowired
	public ParqueaderoService parqueaderoService;
	

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
	
	public boolean tipoVehiculo (String tipo) {
		String tipoCelda = tipo.substring(0, 1);
			if (tipoCelda.equals("c")) {
					return true;
			}return false;
	}
	
	public boolean condicionesIngreso (Vehiculo vehiculo,int celdasCarro, int celdasMoto, String tipo) {
		Date date = new Date();
		String letra = vehiculo.getPlaca();
		if (tipoVehiculo(tipo)) {
			parqueaderoService.consultarCeldasCarro(celdasCarro);
			if ((comprobarLetraInicial(letra)) && (obtenerDia(date))) {
				if (sumarCeldasCarro(celdasCarro)) {
					parqueaderoService.aumentarCeldasCarro(celdasCarro);
				}System.out.println("no hay celdas disponibles"+celdasCarro);
			}
		}else {
			parqueaderoService.consultarCeldasMoto(celdasMoto);
				if ((comprobarLetraInicial(letra)) && (obtenerDia(date))) {
					if (sumarCeldasMoto(celdasMoto)) {
						parqueaderoService.aumentarCeldasMoto(celdasMoto);
					}System.out.println("no hay celdas disponibles"+celdasMoto);
				}
		}
			
			return false;	
	}
	
	public void salidas (int celdasCarro, int celdasMoto, String tipo) {
		if (tipoVehiculo(tipo)) {
			parqueaderoService.disminuirCeldasCarro(celdasCarro);
		}parqueaderoService.disminuirCeldasMoto(celdasMoto);
	}
	
//	public int cobrarMoto (Date fechaEntrada, Date fechaSalida) {
//		
//		long diferencia =  fechaEntrada.getTime()- fechaSalida.getTime();
//		int cobro=0;
//		
//		return (int) diferencia;
//	}
//	
	public boolean sumarCeldasCarro (int celdasCarro) {
		if (celdasCarro<20) {
			celdasCarro= celdasCarro+1;
			return  true;
		}return false;
	}
	
	public boolean sumarCeldasMoto (int celdasMoto) {
		if (celdasMoto<10) {
			celdasMoto=celdasMoto+1;
			return  true;
		}return false;
	}
//	
//	public int disminuirCeldas (int disponiblesCarro, int disponiblesMoto) {
//		return
//	}
	
}
