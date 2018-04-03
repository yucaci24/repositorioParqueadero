package com.ceiba.parqueadero.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Utils {

	public boolean obtenerDia (Date d){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		if ((cal.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY )|| (cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)) {
			return true;
		}return false;
	}
	
	public boolean comprobarLetraInicial (String placa) {	
		String firstLetter = placa.substring(0, 1);
		if (firstLetter.equals("a")) {
			return true;
		}
		return false;
	}
	
}
