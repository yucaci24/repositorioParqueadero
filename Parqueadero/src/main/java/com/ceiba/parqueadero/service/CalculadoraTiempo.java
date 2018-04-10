package com.ceiba.parqueadero.service;

import java.math.BigDecimal;
import java.util.Date;

public class CalculadoraTiempo {
	
	public static final double DAY_IN_SECONDS = 86400;
	public static final double HOURS_IN_SECONDS = 3600;
	public static final double MINUTES_IN_SECONDS = 60;
	
	public int calcularDias( double tiempoInSeconds ){
		int cantDias = 0;
		if ( tiempoInSeconds > DAY_IN_SECONDS ) {
			cantDias = BigDecimal.valueOf( Math.floor( tiempoInSeconds / DAY_IN_SECONDS ) ).intValue();
		}
		return cantDias;
	}
	
	public int calcularHoras( double tiempoInMili ){
		int cantHoras = 0;
		if ( tiempoInMili > HOURS_IN_SECONDS ) {
			cantHoras = BigDecimal.valueOf( Math.floor( tiempoInMili / HOURS_IN_SECONDS ) ).intValue();
		}
		return cantHoras;
	}
	
	public int calcularPorMinutos( double tiempoInMili ){
		int cantMinutos = 0;
		if ( tiempoInMili > MINUTES_IN_SECONDS ) {
			cantMinutos = BigDecimal.valueOf( Math.floor( tiempoInMili / MINUTES_IN_SECONDS ) ).intValue();
		}
		return cantMinutos;
	}
	
	public double calcularDiferenciaTiempoInMili( Date fechaEntrada, Date fechaSalida ) {
		return  BigDecimal.valueOf((fechaSalida.getTime() - fechaEntrada.getTime()) / 1000).doubleValue();
	}

}
