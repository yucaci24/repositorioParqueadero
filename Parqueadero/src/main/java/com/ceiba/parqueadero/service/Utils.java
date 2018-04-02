package com.ceiba.parqueadero.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.parqueadero.model.Parqueadero;


public class Utils {

	
	public int obtenerDiaDeLaSemana(Date d){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_WEEK);		
	} 
	
	
//	public String ComprobarLetraInicial (String placa) {
//		if (placa.length()!=5) {
//			System.out.println("la placa debe tener 6 caracteres");
//			System.out.println(placa);
//		}
//		if (placa.substring(0, 1).equalsIgnoreCase("a")) {
//			System.out.println("empieza por a");
//		}
//		return placa;
//	}
	
	
}
